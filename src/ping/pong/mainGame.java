package ping.pong;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.prefs.Preferences;
import javax.sound.sampled.*;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class mainGame extends javax.swing.JFrame {
    
    // Game components
    private Paddle leftPaddle;
    private Paddle rightPaddle;
    private Ball ball;
    private Goal leftGoal;
    private Goal rightGoal;
    
    // Game settings
    private String playerMode;
    private int paddleSize = 100;   
    private int ballSpeed = 5;
    private int pointsToWin = 5;
    private int volume = 80;
    private String difficulty = "Medium";
    
    // Game state
    private boolean gameRunning = false;
    private boolean gamePaused = false;
    private int leftScore = 0;
    private int rightScore = 0;
    private Timer gameTimer;
    private Timer delayTimer;
    private Random random = new Random();
    
    // Key states for smooth movement
    private boolean upPressed = false;
    private boolean downPressed = false;
    private boolean zPressed = false;
    private boolean sPressed = false;
    
    public mainGame(String type) {
        initComponents();
        this.playerMode = type;
        
        // Load game settings
        loadSettings();
        
        // Initialize game components
        initializeGame();
        
        // Set up key listeners for paddle control
        setupKeyListeners();
        
        // Start the game
        startGame();
    }

    private void loadSettings() {
        try {
            Preferences prefs = Preferences.userRoot().node(settings.class.getName());
            
            // Load all settings
            difficulty = prefs.get("DIFFICULTY", "Medium");
            ballSpeed = prefs.getInt("BALL_SPEED", 5);
            paddleSize = prefs.getInt("PADDLE_SIZE", 100);
            pointsToWin = prefs.getInt("POINTS_TO_WIN", 5);
            volume = prefs.getInt("VOLUME", 80);
        } catch (Exception e) {
            System.err.println("Error loading settings: " + e.getMessage());
        }
    }
    
    private void initializeGame() {
        // Make Components panel use absolute layout
        Components.setLayout(null);
        statusLabel.setText("");
        statusLabel.setVisible(false);
        // Initialize paddles
        int paddleWidth = 10;
        int paddleHeight = paddleSize;
        int paddleSpeed = 8;
        
        leftPaddle = new Paddle(20, Components.getHeight()/2 - paddleHeight/2, 
                               paddleWidth, paddleHeight, paddleSpeed);
        rightPaddle = new Paddle(Components.getWidth() - 20 - paddleWidth, 
                                Components.getHeight()/2 - paddleHeight/2, 
                                paddleWidth, paddleHeight, paddleSpeed);
        
        // Initialize ball
        int ballSize = 20;
        ball = new Ball(Components.getWidth()/2 - ballSize/2, 
                       Components.getHeight()/2 - ballSize/2, 
                       ballSize, ballSize, ballSpeed);
        
        // Initialize goals
        int goalWidth = 10;
        leftGoal = new Goal(0, 0, goalWidth, Components.getHeight());
        rightGoal = new Goal(Components.getWidth() - goalWidth, 0, goalWidth, Components.getHeight());
        
        // Add components to the panel
        Components.add(leftPaddle);
        Components.add(rightPaddle);
        Components.add(ball);
        
        // Set up the Table panel for boundaries
        Table.setLayout(null);
        Table.add(leftGoal);
        Table.add(rightGoal);
        
        // Initialize score display
        updateScoreDisplay();
        
        // Set status label
        statusLabel.setText("Get Ready!");
    }
    
    private void setupKeyListeners() {
        // Set focus to the frame for keyboard input
        this.setFocusable(true);
        this.requestFocus();
        
        // Add key listener for paddle control
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        upPressed = true;
                        break;
                    case KeyEvent.VK_DOWN:
                        downPressed = true;
                        break;
                    case KeyEvent.VK_Z:
                        zPressed = true;
                        break;
                    case KeyEvent.VK_S:
                        sPressed = true;
                        break;
                    case KeyEvent.VK_SPACE:
                        togglePause();
                        break;
                }
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                        upPressed = false;
                        break;
                    case KeyEvent.VK_DOWN:
                        downPressed = false;
                        break;
                    case KeyEvent.VK_Z:
                        zPressed = false;
                        break;
                    case KeyEvent.VK_S:
                        sPressed = false;
                        break;
                }
            }
        });
    }
    
    private void startGame() {
        // Set initial game state
        gameRunning = true;
        gamePaused = false;
        
        // Start with a delay
        statusLabel.setText("Get Ready!");
        delayTimer = new Timer(2000, e -> {
            statusLabel.setText("");
            launchBall();
            startGameLoop();
            ((Timer)e.getSource()).stop();
        });
        delayTimer.setRepeats(false);
        delayTimer.start();
    }
    
    private void launchBall() {
        // Reset ball position
        ball.x = Components.getWidth()/2 - ball.width/2;
        ball.y = Components.getHeight()/2 - ball.height/2;
        
        // Set random direction
        double angle;
        if (random.nextBoolean()) {
            // Launch towards right
            angle = Math.toRadians(random.nextInt(120) - 60); // -60 to 60 degrees
        } else {
            // Launch towards left
            angle = Math.toRadians(random.nextInt(120) + 120); // 120 to 240 degrees
        }
        
        // Set velocity based on angle and speed
        ball.setVelocity(
            Math.cos(angle) * ballSpeed,
            Math.sin(angle) * ballSpeed
        );
    }
    
    private void launchBallAfterGoal(boolean towardsRight) {
        // Reset ball position
        ball.x = Components.getWidth()/2 - ball.width/2;
        ball.y = Components.getHeight()/2 - ball.height/2;
        
        // Set direction based on who scored
        double angle;
        if (towardsRight) {
            // Launch towards right
            angle = Math.toRadians(random.nextInt(90) - 45); // -45 to 45 degrees
        } else {
            // Launch towards left
            angle = Math.toRadians(random.nextInt(90) + 135); // 135 to 225 degrees
        }
        
        // Set velocity based on angle and speed
        ball.setVelocity(
            Math.cos(angle) * ballSpeed,
            Math.sin(angle) * ballSpeed
        );
    }
    
    private void startGameLoop() {
        // Create game timer for the main game loop
        gameTimer = new Timer(6, e -> { //Starts every 6ms
            if (!gamePaused && gameRunning) {
                updateGame();
                Components.repaint();
                Table.repaint();
            }
        });
        gameTimer.start();
    }
    
    private void updateGame() {
        // Update paddle positions based on key states
        if (zPressed) {
            leftPaddle.moveUp();
        }
        if (sPressed) {
            leftPaddle.moveDown(Components.getHeight());
        }
        
        // Update right paddle based on game mode
        if (playerMode.equals("Player")) {
            // Player 2 controls
            if (upPressed) {
                rightPaddle.moveUp();
            }
            if (downPressed) {
                rightPaddle.moveDown(Components.getHeight());
            }
        } else {
            // AI controls
            updateAI();
        }
        
        // Update ball position
        ball.update();
        
        // Check for collisions
        checkCollisions();
        
        // Check for goals
        checkGoals();
    }
    
    private void updateAI() {    
        // AI difficulty affects reaction time and accuracy
        double reactionSpeed;
        double accuracy;
        
        switch (difficulty) {
            case "Easy":
                // Random movement
                if (random.nextInt(100) < 30) {
                    if (random.nextBoolean()) {
                        rightPaddle.moveUp();
                    } else {
                        rightPaddle.moveDown(Components.getHeight());
                    }
                }
                break;
                
            case "Medium":
                // Follows ball but with delay and less accuracy
                reactionSpeed = 0.5;
                accuracy = 30;
                
                // Only move if ball is moving towards AI
                if (ball.dx > 0) {
                    double targetY = ball.y + ball.height/2 - rightPaddle.height/2;
                    targetY += (random.nextDouble() * 2 - 1) * accuracy;
                    
                    // Use paddle's move methods instead of modifying y directly
                    if (rightPaddle.y + rightPaddle.height/2 < targetY - 10) {
                        rightPaddle.y += rightPaddle.speed * reactionSpeed;
                        rightPaddle.setBounds(rightPaddle.x, rightPaddle.y, rightPaddle.width, rightPaddle.height);
                    } else if (rightPaddle.y + rightPaddle.height/2 > targetY + 10) {
                        rightPaddle.y -= rightPaddle.speed * reactionSpeed;
                        rightPaddle.setBounds(rightPaddle.x, rightPaddle.y, rightPaddle.width, rightPaddle.height);
                    }
                }
                break;
                
            case "Hard":
                // Follows ball perfectly with minimal delay
                reactionSpeed = 1;
                accuracy = 10;
                
                double targetY = ball.y + ball.height/2 - rightPaddle.height/2;
                targetY += (random.nextDouble() * 2 - 1) * accuracy;
                
                // Use paddle's move methods instead of modifying y directly
                if (rightPaddle.y + rightPaddle.height/2 < targetY - 5) {
                    rightPaddle.y += rightPaddle.speed * reactionSpeed;
                    rightPaddle.setBounds(rightPaddle.x, rightPaddle.y, rightPaddle.width, rightPaddle.height);
                } else if (rightPaddle.y + rightPaddle.height/2 > targetY + 5) {
                    rightPaddle.y -= rightPaddle.speed * reactionSpeed;
                    rightPaddle.setBounds(rightPaddle.x, rightPaddle.y, rightPaddle.width, rightPaddle.height);
                }
                break;
        }
    }
    
    private void checkCollisions() {
        // Ball collision with top and bottom walls
        if (ball.y <= 0 || ball.y + ball.height >= Components.getHeight()) {
            ball.dy = -ball.dy;
            ball.y = ball.y <= 0 ? 0 : Components.getHeight() - ball.height;
            ball.setBounds(ball.x, ball.y, ball.width, ball.height);
            playSound("wall_hit.wav");
        }
        
        // Ball collision with paddles
        if (ball.intersects(leftPaddle)) {
            handlePaddleCollision(leftPaddle);
            playSound("paddle_hit.wav");
        } else if (ball.intersects(rightPaddle)) {
            handlePaddleCollision(rightPaddle);
            playSound("paddle_hit.wav");
        }
    }
    
    private void handlePaddleCollision(Paddle paddle) {
        // First, adjust ball position to be outside the paddle
        if (ball.dx > 0) { // Moving right - hit left side of paddle
            ball.x = paddle.x - ball.width;
        } else { // Moving left - hit right side of paddle
            ball.x = paddle.x + paddle.width;
        }
        
        // Calculate bounce angle based on where ball hits paddle
        double relativeIntersectY = (paddle.y + (paddle.height / 2.0)) - (ball.y + (ball.height / 2.0));
        double normalizedRelativeIntersectionY = relativeIntersectY / (paddle.height / 2.0);
        double bounceAngle = normalizedRelativeIntersectionY * Math.toRadians(60); // Max 60 degree bounce

        // Calculate new velocity while maintaining speed
        double speed = Math.sqrt(ball.dx * ball.dx + ball.dy * ball.dy); 
        double newDx = (ball.dx > 0 ? -1 : 1) * (Math.cos(bounceAngle)) * speed;
        double newDy = -Math.sin(bounceAngle) * speed;

        // Use setVelocity to update the ball's velocity
        ball.setVelocity(newDx, newDy);

        // Update ball position
        ball.setBounds(ball.x, ball.y, ball.width, ball.height);
    }
    
    private void checkGoals() {
        // Check if ball intersects with goals
        if (ball.x <= leftGoal.x + leftGoal.width) {
            // Right player scores
            rightScore++;
            updateScoreDisplay();
            playSound("goal.wav");
            handleGoal(false);
        } else if (ball.x + ball.width >= rightGoal.x) {
            // Left player scores
            leftScore++;
            updateScoreDisplay();
            playSound("goal.wav");
            handleGoal(true);
        }
    }
    
    private void handleGoal(boolean leftScored) {
        // Stop the game temporarily
        gameRunning = false;
        
        // Check if game is over
        if (leftScore >= pointsToWin || rightScore >= pointsToWin) {
            endGame();
            return;
        }
        
        // Display who scored
        statusLabel.setText(leftScored ? "Left Scores!" : "Right Scores!");
        
        // Restart after delay
        delayTimer = new Timer(2000, e -> {
            statusLabel.setText("");
            launchBallAfterGoal(!leftScored); // Launch towards player who got scored on
            gameRunning = true;
            ((Timer)e.getSource()).stop();
        });
        delayTimer.setRepeats(false);
        delayTimer.start();
    }
    
    private void endGame() {
        // Stop the game
        gameRunning = false;
        if (gameTimer != null) {
            gameTimer.stop();
        }

        // Display winner
        if (playerMode.equals("AI")) {
            statusLabel.setText(leftScore > rightScore ? "You Win!" : "AI Wins!");
        } else {
            statusLabel.setText(leftScore > rightScore ? "Player 1 Wins!" : "Player 2 Wins!");
        }
        statusLabel.setVisible(true);

    }
    
    private void togglePause() {
        gamePaused = !gamePaused;
        if (gamePaused) {
            statusLabel.setText("PAUSED");
            statusLabel.setVisible(true);
        } else {
            statusLabel.setText("");
            statusLabel.setVisible(false);
        }
    }
    
    private void updateScoreDisplay() {
        scoreLabel.setText(leftScore + " : " + rightScore);
    }
    
    private void playSound(String soundFile) {
        // Skip if volume is 0
        if (volume <= 0) {
            return;
        }
        
        try {
            
            File file = new File("src/soundEffect/" + soundFile);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(file);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            
            // Set volume
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float dB = (float) (Math.log(volume / 100.0) / Math.log(10.0) * 20.0);
            gainControl.setValue(dB);
            
            clip.start();
        } catch (Exception e) {
            System.err.println("Error playing sound: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scoreLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        Components = new javax.swing.JPanel();
        Table = new javax.swing.JPanel();
        goBack = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scoreLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        scoreLabel.setForeground(new java.awt.Color(255, 255, 255));
        scoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreLabel.setText("0 : 0");
        getContentPane().add(scoreLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 70, 40));

        statusLabel.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusLabel.setOpaque(true);
        getContentPane().add(statusLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 750, -1, -1));

        Components.setOpaque(false);

        javax.swing.GroupLayout ComponentsLayout = new javax.swing.GroupLayout(Components);
        Components.setLayout(ComponentsLayout);
        ComponentsLayout.setHorizontalGroup(
            ComponentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        ComponentsLayout.setVerticalGroup(
            ComponentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        getContentPane().add(Components, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 980, 540));

        Table.setOpaque(false);

        javax.swing.GroupLayout TableLayout = new javax.swing.GroupLayout(Table);
        Table.setLayout(TableLayout);
        TableLayout.setHorizontalGroup(
            TableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
        );
        TableLayout.setVerticalGroup(
            TableLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 540, Short.MAX_VALUE)
        );

        getContentPane().add(Table, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 150, 980, 540));

        goBack.setBorder(null);
        goBack.setBorderPainted(false);
        goBack.setContentAreaFilled(false);
        goBack.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        goBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goBackActionPerformed(evt);
            }
        });
        getContentPane().add(goBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 30, 310, 90));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/mainGame.jpg"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void goBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackActionPerformed
        // Stop game timers
        if (gameTimer != null) {
            gameTimer.stop();
        }
        if (delayTimer != null) {
            delayTimer.stop();
        }
        new MainMenu().setVisible(true);
        dispose();
    }//GEN-LAST:event_goBackActionPerformed

    // Game component classes
    // Paddle class
    class Paddle extends JComponent {
        public int x;
        public int y;
        public int width;
        public int height;
        public int speed;
        
        public Paddle(int x, int y, int width, int height, int speed) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            this.speed = speed;
            
            // Set bounds for rendering
            setBounds(x, y, width, height);
        }
        
        public void moveUp() {
            if (y > 0) {
                y -= speed;
                setBounds(x, y, width, height);
            }
        }
        
        public void moveDown(int containerHeight) {
            if (y + height < containerHeight) {
                y += speed;
                setBounds(x, y, width, height);
            }
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.WHITE);
            g.fillRect(0, 0, width, height);
        }
    }
    
    // Ball class
    class Ball extends JComponent {
        public int x;
        public int y;
        public int width;
        public int height;
        public double dx;
        public double dy;
        
        public Ball(int x, int y, int width, int height, int speed) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            
            // Set bounds for rendering
            setBounds(x, y, width, height);
        }
        
        public void setVelocity(double dx, double dy) {
            this.dx = dx;
            this.dy = dy;
        }
        
        public void update() {
            x += dx;
            y += dy;
            setBounds(x, y, width, height);
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(Color.YELLOW);
            g.fillOval(0, 0, width, height);
        }
        
        public boolean intersects(Paddle paddle) {
            // Create rectangles for collision detection
            Rectangle ballRect = new Rectangle(x, y, width, height);
            Rectangle paddleRect = new Rectangle(paddle.x, paddle.y, paddle.width, paddle.height);

            // Check if the rectangles intersect
            return ballRect.intersects(paddleRect);
        }

    }
    
    // Goal class
    class Goal extends JComponent {
        private int x;
        private int y;
        private int width;
        private int height;
        public Goal(int x, int y, int width, int height) {
            this.x = x;
            this.y = y;
            this.width = width;
            this.height = height;
            
            // Set bounds for rendering
            setBounds(x, y, width, height);
        }
        
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(new Color(255, 255, 255, 50)); // Semi-transparent white
            g.fillRect(0, 0, width, height);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JPanel Components;
    private javax.swing.JPanel Table;
    private javax.swing.JButton goBack;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}

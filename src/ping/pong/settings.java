package ping.pong;
import javax.swing.*;
import java.awt.*;
import java.util.prefs.Preferences;

public class settings extends javax.swing.JFrame {

    public settings() {
    initComponents();
    saveButton.addActionListener(e -> saveSettings()); 
    loadSettings();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        goBack = new javax.swing.JButton();
        pointsToWinComboBox = new javax.swing.JComboBox<>();
        audioVolumeSlider = new javax.swing.JSlider();
        ballSpeedSlider = new javax.swing.JSlider();
        difficultyComboBox = new javax.swing.JComboBox<>();
        paddleSizeSlider = new javax.swing.JSlider();
        saveButton = new javax.swing.JButton();
        resetButton = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        pointsToWinComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new Integer[] { 3, 5, 10, 15, 21 }));
        pointsToWinComboBox.setSelectedIndex(1);
        pointsToWinComboBox.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().add(pointsToWinComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 510, 220, 40));

        audioVolumeSlider.setBackground(new java.awt.Color(39, 77, 37));
        audioVolumeSlider.setValue(80);
        getContentPane().add(audioVolumeSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 600, 220, 40));

        ballSpeedSlider.setBackground(new java.awt.Color(39, 77, 37));
        ballSpeedSlider.setForeground(new java.awt.Color(255, 255, 255));
        ballSpeedSlider.setMajorTickSpacing(3);
        ballSpeedSlider.setMaximum(10);
        ballSpeedSlider.setMinimum(1);
        ballSpeedSlider.setMinorTickSpacing(1);
        ballSpeedSlider.setPaintLabels(true);
        ballSpeedSlider.setPaintTicks(true);
        ballSpeedSlider.setValue(5);
        getContentPane().add(ballSpeedSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, 220, 40));

        difficultyComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Easy", "Medium", "Hard" }));
        getContentPane().add(difficultyComboBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 240, 220, 40));

        paddleSizeSlider.setBackground(new java.awt.Color(39, 77, 37));
        paddleSizeSlider.setForeground(new java.awt.Color(255, 255, 255));
        paddleSizeSlider.setMajorTickSpacing(50);
        paddleSizeSlider.setMaximum(200);
        paddleSizeSlider.setMinimum(30);
        paddleSizeSlider.setPaintLabels(true);
        paddleSizeSlider.setPaintTicks(true);
        paddleSizeSlider.setValue(100);
        getContentPane().add(paddleSizeSlider, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 420, 220, 40));

        saveButton.setBorder(null);
        saveButton.setBorderPainted(false);
        saveButton.setContentAreaFilled(false);
        saveButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(saveButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 690, 200, 70));

        resetButton.setBorder(null);
        resetButton.setBorderPainted(false);
        resetButton.setContentAreaFilled(false);
        resetButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resetButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetButtonActionPerformed(evt);
            }
        });
        getContentPane().add(resetButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 690, 210, 70));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Settings.jpg"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void goBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackActionPerformed
        new MainMenu().setVisible(true);
        dispose();
    }//GEN-LAST:event_goBackActionPerformed

    private void resetButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetButtonActionPerformed
        difficultyComboBox.setSelectedItem("Medium");
        ballSpeedSlider.setValue(5);
        paddleSizeSlider.setValue(100);
        pointsToWinComboBox.setSelectedItem(10);
        audioVolumeSlider.setValue(80);
    }//GEN-LAST:event_resetButtonActionPerformed
    // Save settings to persistent storage
    private void saveSettings() {
        try {
            Preferences prefs = Preferences.userRoot().node(this.getClass().getName());

            // Save all settings
            prefs.put("DIFFICULTY", (String) difficultyComboBox.getSelectedItem());
            prefs.putInt("BALL_SPEED", ballSpeedSlider.getValue());
            prefs.putInt("PADDLE_SIZE", paddleSizeSlider.getValue());
            prefs.putInt("POINTS_TO_WIN", (Integer) pointsToWinComboBox.getSelectedItem());
            prefs.putInt("VOLUME", audioVolumeSlider.getValue());

            JOptionPane.showMessageDialog(this, "Settings saved successfully!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error saving settings: " + e.getMessage(), 
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private void loadSettings() {
        try {
            Preferences prefs = Preferences.userRoot().node(this.getClass().getName());

            // Load all settings
            difficultyComboBox.setSelectedItem(prefs.get("DIFFICULTY", "Medium"));
            ballSpeedSlider.setValue(prefs.getInt("BALL_SPEED", 5));
            paddleSizeSlider.setValue(prefs.getInt("PADDLE_SIZE", 100));
            pointsToWinComboBox.setSelectedItem(prefs.getInt("POINTS_TO_WIN", 10));
            audioVolumeSlider.setValue(prefs.getInt("VOLUME", 80));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error loading settings: " + e.getMessage(),
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
        
    private void initializeSettings() {
        // 1. Connect the save button
        saveButton.addActionListener(e -> saveSettings());
        // 2. Load saved settings
        loadSettings();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JSlider audioVolumeSlider;
    private javax.swing.JSlider ballSpeedSlider;
    private javax.swing.JComboBox<String> difficultyComboBox;
    private javax.swing.JButton goBack;
    private javax.swing.JSlider paddleSizeSlider;
    private javax.swing.JComboBox<Integer> pointsToWinComboBox;
    private javax.swing.JButton resetButton;
    private javax.swing.JButton saveButton;
    // End of variables declaration//GEN-END:variables
}

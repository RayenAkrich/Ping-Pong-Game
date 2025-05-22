package ping.pong;

public class gameModes extends javax.swing.JFrame {

    public gameModes() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        goBack = new javax.swing.JButton();
        vsAi = new javax.swing.JButton();
        vsPlayer = new javax.swing.JButton();
        howToPlay = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setPreferredSize(new java.awt.Dimension(1280, 800));
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

        vsAi.setBorder(null);
        vsAi.setBorderPainted(false);
        vsAi.setContentAreaFilled(false);
        vsAi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vsAi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vsAiActionPerformed(evt);
            }
        });
        getContentPane().add(vsAi, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 550, 330, 50));

        vsPlayer.setBorder(null);
        vsPlayer.setBorderPainted(false);
        vsPlayer.setContentAreaFilled(false);
        vsPlayer.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vsPlayer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vsPlayerActionPerformed(evt);
            }
        });
        getContentPane().add(vsPlayer, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 550, 340, 50));

        howToPlay.setBorder(null);
        howToPlay.setBorderPainted(false);
        howToPlay.setContentAreaFilled(false);
        howToPlay.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        howToPlay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                howToPlayActionPerformed(evt);
            }
        });
        getContentPane().add(howToPlay, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 620, 360, 60));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/GameModes.jpg"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void goBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackActionPerformed
        new MainMenu().setVisible(true);
        dispose();
    }//GEN-LAST:event_goBackActionPerformed

    private void vsAiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vsAiActionPerformed
        new mainGame("AI").setVisible(true);
        dispose();
    }//GEN-LAST:event_vsAiActionPerformed

    private void vsPlayerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vsPlayerActionPerformed
        new mainGame("Player").setVisible(true);
        dispose();
    }//GEN-LAST:event_vsPlayerActionPerformed

    private void howToPlayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_howToPlayActionPerformed
        new howToPlay().setVisible(true);
        dispose();
    }//GEN-LAST:event_howToPlayActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton goBack;
    private javax.swing.JButton howToPlay;
    private javax.swing.JButton vsAi;
    private javax.swing.JButton vsPlayer;
    // End of variables declaration//GEN-END:variables
}

package ping.pong;

public class howToPlay extends javax.swing.JFrame {

    public howToPlay() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        goBack = new javax.swing.JButton();
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

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/HowToPlay.jpg"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void goBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackActionPerformed
        new gameModes().setVisible(true);
        dispose();
    }//GEN-LAST:event_goBackActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton goBack;
    // End of variables declaration//GEN-END:variables
}

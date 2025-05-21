package ping.pong;

import javax.swing.JFrame;

public class MainMenu extends javax.swing.JFrame {

    public MainMenu() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Contact = new javax.swing.JButton();
        Settings = new javax.swing.JButton();
        Gamemodes = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 800));
        setMinimumSize(new java.awt.Dimension(1280, 800));
        setPreferredSize(new java.awt.Dimension(1280, 800));
        setResizable(false);
        setSize(new java.awt.Dimension(1280, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Contact.setBorder(null);
        Contact.setBorderPainted(false);
        Contact.setContentAreaFilled(false);
        Contact.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Contact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContactActionPerformed(evt);
            }
        });
        getContentPane().add(Contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 550, 340, 50));

        Settings.setBorder(null);
        Settings.setBorderPainted(false);
        Settings.setContentAreaFilled(false);
        Settings.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Settings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SettingsActionPerformed(evt);
            }
        });
        getContentPane().add(Settings, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 550, 340, 50));

        Gamemodes.setBorder(null);
        Gamemodes.setBorderPainted(false);
        Gamemodes.setContentAreaFilled(false);
        Gamemodes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Gamemodes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GamemodesActionPerformed(evt);
            }
        });
        getContentPane().add(Gamemodes, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 630, 350, 50));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/MainMenu.jpg"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContactActionPerformed
        new contact().setVisible(true);
        dispose();
    }//GEN-LAST:event_ContactActionPerformed

    private void SettingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SettingsActionPerformed
        new settings().setVisible(true);
        dispose();
    }//GEN-LAST:event_SettingsActionPerformed

    private void GamemodesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GamemodesActionPerformed
        new gameModes().setVisible(true);
        dispose();
    }//GEN-LAST:event_GamemodesActionPerformed

    public static void main(String args[]) {
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton Contact;
    private javax.swing.JButton Gamemodes;
    private javax.swing.JButton Settings;
    // End of variables declaration//GEN-END:variables
}

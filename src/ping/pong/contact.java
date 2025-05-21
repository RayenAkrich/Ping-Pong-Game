package ping.pong;

public class contact extends javax.swing.JFrame {

    public contact() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        goBack = new javax.swing.JButton();
        Facebook = new javax.swing.JButton();
        Instagram = new javax.swing.JButton();
        LinkedIn = new javax.swing.JButton();
        Github = new javax.swing.JButton();
        Gmail = new javax.swing.JButton();
        Background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1280, 800));
        setMinimumSize(new java.awt.Dimension(1280, 800));
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

        Facebook.setBorder(null);
        Facebook.setBorderPainted(false);
        Facebook.setContentAreaFilled(false);
        Facebook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Facebook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FacebookActionPerformed(evt);
            }
        });
        getContentPane().add(Facebook, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 570, 170, 180));

        Instagram.setBorder(null);
        Instagram.setBorderPainted(false);
        Instagram.setContentAreaFilled(false);
        Instagram.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Instagram.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InstagramActionPerformed(evt);
            }
        });
        getContentPane().add(Instagram, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 570, 170, 180));

        LinkedIn.setBorder(null);
        LinkedIn.setBorderPainted(false);
        LinkedIn.setContentAreaFilled(false);
        LinkedIn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        LinkedIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LinkedInActionPerformed(evt);
            }
        });
        getContentPane().add(LinkedIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 570, 170, 180));

        Github.setBorder(null);
        Github.setBorderPainted(false);
        Github.setContentAreaFilled(false);
        Github.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Github.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GithubActionPerformed(evt);
            }
        });
        getContentPane().add(Github, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 570, 170, 180));

        Gmail.setBorder(null);
        Gmail.setBorderPainted(false);
        Gmail.setContentAreaFilled(false);
        Gmail.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        Gmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GmailActionPerformed(evt);
            }
        });
        getContentPane().add(Gmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 570, 170, 180));

        Background.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Contact.jpg"))); // NOI18N
        getContentPane().add(Background, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 800));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void goBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goBackActionPerformed
        new MainMenu().setVisible(true);
        dispose();
    }//GEN-LAST:event_goBackActionPerformed

    private void FacebookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FacebookActionPerformed
        try {
            // Open the Facebook URL in the default browser
            java.awt.Desktop.getDesktop().browse(new java.net.URI("https://www.facebook.com/rayen.akrich.0/"));
        } catch (Exception e) {
            // Show error message if something goes wrong (e.g., no browser support)
            javax.swing.JOptionPane.showMessageDialog(this, "Failed to open Facebook: " + e.getMessage());
        }
    }//GEN-LAST:event_FacebookActionPerformed

    private void InstagramActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InstagramActionPerformed
        try {
            // Open the Instagram URL in the default browser
            java.awt.Desktop.getDesktop().browse(new java.net.URI("https://www.instagram.com/rayen._.akrich/"));
        } catch (Exception e) {
            // Show error message if something goes wrong (e.g., no browser support)
            javax.swing.JOptionPane.showMessageDialog(this, "Failed to open Instagram: " + e.getMessage());
        }
    }//GEN-LAST:event_InstagramActionPerformed

    private void LinkedInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LinkedInActionPerformed
        try {
            // Open the LinkedIN URL in the default browser
            java.awt.Desktop.getDesktop().browse(new java.net.URI("https://www.linkedin.com/in/akricherayen/"));
        } catch (Exception e) {
            // Show error message if something goes wrong (e.g., no browser support)
            javax.swing.JOptionPane.showMessageDialog(this, "Failed to open LinkedIN: " + e.getMessage());
        }
    }//GEN-LAST:event_LinkedInActionPerformed

    private void GithubActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GithubActionPerformed
        try {
            // Open the Github URL in the default browser
            java.awt.Desktop.getDesktop().browse(new java.net.URI("https://github.com/RayenAkrich"));
        } catch (Exception e) {
            // Show error message if something goes wrong (e.g., no browser support)
            javax.swing.JOptionPane.showMessageDialog(this, "Failed to open Github: " + e.getMessage());
        }
    }//GEN-LAST:event_GithubActionPerformed

    private void GmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GmailActionPerformed
        try {
            // Open the Gmail URL in the default browser
            java.awt.Desktop.getDesktop().browse(new java.net.URI("mailto:akricherayen@gmail.com"));
        } catch (Exception e) {
            // Show error message if something goes wrong (e.g., no browser support)
            javax.swing.JOptionPane.showMessageDialog(this, "Failed to open Gmail: " + e.getMessage());
        }
    }//GEN-LAST:event_GmailActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Background;
    private javax.swing.JButton Facebook;
    private javax.swing.JButton Github;
    private javax.swing.JButton Gmail;
    private javax.swing.JButton Instagram;
    private javax.swing.JButton LinkedIn;
    private javax.swing.JButton goBack;
    // End of variables declaration//GEN-END:variables
}

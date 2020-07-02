package ui.form;

import controller.Controller;
import domain.Radnik;
import java.net.SocketException;
import javax.swing.JOptionPane;
import ui.form_validation.LoginFormValidation;

public class FPrijavaRadnika extends javax.swing.JFrame {

    public FPrijavaRadnika() {
        initComponents();
        prepareForm();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlabUsername = new javax.swing.JLabel();
        jtxtUsername = new javax.swing.JTextField();
        jlabPassword = new javax.swing.JLabel();
        jtxtPassword = new javax.swing.JPasswordField();
        btnPrijaviSe = new javax.swing.JButton();
        jlabUsernameError = new javax.swing.JLabel();
        jlabPasswordError = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Unesite vase podatke za logovanje");
        setBackground(new java.awt.Color(51, 0, 255));

        jlabUsername.setText("username:");

        jtxtUsername.setToolTipText("");

        jlabPassword.setText("password:");

        btnPrijaviSe.setBackground(new java.awt.Color(255, 204, 204));
        btnPrijaviSe.setForeground(new java.awt.Color(153, 0, 153));
        btnPrijaviSe.setText("Prijavi se");
        btnPrijaviSe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrijaviSeActionPerformed(evt);
            }
        });

        jlabUsernameError.setForeground(new java.awt.Color(255, 0, 51));

        jlabPasswordError.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(jlabPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jtxtPassword))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlabPasswordError, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlabUsernameError, javax.swing.GroupLayout.PREFERRED_SIZE, 336, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlabUsername, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(236, 236, 236)
                                        .addComponent(btnPrijaviSe, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jtxtUsername))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabUsername)
                    .addComponent(jtxtUsername, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabUsernameError, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabPassword)
                    .addComponent(jtxtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlabPasswordError, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnPrijaviSe)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPrijaviSeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrijaviSeActionPerformed
        try {

            Radnik radnik = new Radnik(jtxtUsername.getText().trim(), String.valueOf(jtxtPassword.getPassword()).trim());
            LoginFormValidation.validate(radnik);
            radnik = Controller.getInstance().prijaviRadnika(radnik);
            JOptionPane.showMessageDialog(this, "Uspesna prijava na sistem! \n Ulogovani radnik je: " + radnik.toString());
            dispose();
            new FMain(radnik).setVisible(true);
        } catch (SocketException e) {
            JOptionPane.showConfirmDialog(this, "Server nije pokrenut !", "Greska", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(this, e.getMessage(), "Greska", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnPrijaviSeActionPerformed

    private void prepareForm() {
        setLocationRelativeTo(null);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnPrijaviSe;
    private javax.swing.JLabel jlabPassword;
    private javax.swing.JLabel jlabPasswordError;
    private javax.swing.JLabel jlabUsername;
    private javax.swing.JLabel jlabUsernameError;
    private javax.swing.JPasswordField jtxtPassword;
    private javax.swing.JTextField jtxtUsername;
    // End of variables declaration//GEN-END:variables

}

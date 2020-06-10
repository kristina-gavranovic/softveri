/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.form;

import controller.Controller;
import domain.Clan;
import domain.Zaduzenje;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ui.component.table.model.ZaduzenjeTableModel;

/**
 *
 * @author krist
 */
public class FVracanjeKnjige extends javax.swing.JDialog {

    /**
     * Creates new form FVracanjeKnjige
     */
    public FVracanjeKnjige(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        prepareForm();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        cmbClan = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaZaduzenja = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        btnVrati = new javax.swing.JButton();
        btnZaduzenja = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Vracanje knjige", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(255, 0, 204))); // NOI18N

        jLabel1.setText("Izaberite clana:");

        cmbClan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbClan.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbClanItemStateChanged(evt);
            }
        });

        tabelaZaduzenja.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabelaZaduzenja);

        jLabel2.setText("Izaberite primerak za vracanje:");

        btnVrati.setText("Vrati knjigu");
        btnVrati.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVratiActionPerformed(evt);
            }
        });

        btnZaduzenja.setText("pronadji");
        btnZaduzenja.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZaduzenjaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 754, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cmbClan, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(57, 57, 57)
                                .addComponent(btnZaduzenja))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(btnVrati, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbClan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnZaduzenja))
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnVrati)
                .addContainerGap(26, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbClanItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbClanItemStateChanged
        // TODO add your handling code here:
        Clan clan = (Clan) cmbClan.getSelectedItem();
        if (clan == null) {
            clan = new Clan(-1);
        }

        try {
            ArrayList<Zaduzenje> zaduzenjaClana = Controller.getInstance().vratiZaduzenjaClana(clan.getId());

            ((ZaduzenjeTableModel) tabelaZaduzenja.getModel()).setZaduzenja(zaduzenjaClana);

//            List<Zaduzenje> searchResults = new ArrayList<>();
//
//            for (Zaduzenje zaduzenje : zaduzenjaClana) {
//                if (zaduzenje.getClan().getId() == clan.getId()) {
//                    searchResults.add(zaduzenje);
//                }
//            }
//            if (clan.getId() == -1) {
//                ((ZaduzenjeTableModel) tabelaZaduzenja.getModel()).setZaduzenja(zaduzenjaClana);
//            } else {
//                ((ZaduzenjeTableModel) tabelaZaduzenja.getModel()).setZaduzenja((ArrayList<Zaduzenje>) searchResults);
//            }
        } catch (Exception ex) {
            Logger.getLogger(FVracanjeKnjige.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_cmbClanItemStateChanged

    private void btnZaduzenjaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZaduzenjaActionPerformed
        // TODO add your handling code here:
        Clan clan = (Clan) cmbClan.getSelectedItem();
        if (clan == null) {
            clan = new Clan(-1);
        }

        try {
            ArrayList<Zaduzenje> zaduzenjaClana = Controller.getInstance().vratiZaduzenjaClana(clan.getId());
            ((ZaduzenjeTableModel) tabelaZaduzenja.getModel()).setZaduzenja(zaduzenjaClana);

        } catch (Exception ex) {
            Logger.getLogger(FVracanjeKnjige.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnZaduzenjaActionPerformed

    private void btnVratiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVratiActionPerformed
        // TODO add your handling code here:

        int selectedRow = tabelaZaduzenja.getSelectedRow();
        if (selectedRow != -1) {
            try {

                Controller.getInstance().vratiKnjigu(((ZaduzenjeTableModel) tabelaZaduzenja.getModel()).getZaduzenja().get(selectedRow));
                JOptionPane.showMessageDialog(this, "Uspesno vracena knjiga");

            } catch (Exception ex) {
                Logger.getLogger(FVracanjeKnjige.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Izaberite iz liste primerak koji zelite da vratite");
        }

    }//GEN-LAST:event_btnVratiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FVracanjeKnjige.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FVracanjeKnjige.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FVracanjeKnjige.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FVracanjeKnjige.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FVracanjeKnjige dialog = new FVracanjeKnjige(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVrati;
    private javax.swing.JButton btnZaduzenja;
    private javax.swing.JComboBox cmbClan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaZaduzenja;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        ZaduzenjeTableModel ztm = new ZaduzenjeTableModel();
        tabelaZaduzenja.setModel(ztm);

        cmbClan.removeAllItems();
        cmbClan.removeAllItems();
        ArrayList<Clan> listClanovi = new ArrayList<>();
        try {
            listClanovi = Controller.getInstance().vratiSveClanove();
        } catch (Exception ex) {
            Logger.getLogger(FUnosNovogZaduzenja.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Clan clan : listClanovi) {
            cmbClan.addItem(clan);
        }

    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.form;

import controller.Controller;
import domain.Clan;
import domain.Knjiga;
import domain.Zaduzenje;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ui.component.table.model.ZaduzenjeTableModel;

public class FVracanjeKnjige extends javax.swing.JFrame {

    public FVracanjeKnjige() {

        initComponents();
        prepareForm();
    }

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
                                .addComponent(cmbClan, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(btnVrati, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cmbClan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
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
        Clan clan = (Clan) cmbClan.getSelectedItem();

        if (clan != null) {
            try {

                ArrayList<Zaduzenje> zaduzenjaClana = Controller.getInstance().vratiZaduzenjaClana(clan.getId());
                ArrayList<Knjiga> knjige = Controller.getInstance().vratiSveKnjige();

                ((ZaduzenjeTableModel) tabelaZaduzenja.getModel()).setZaduzenja(zaduzenjaClana, knjige);

            } catch (Exception ex) {
                Logger.getLogger(FVracanjeKnjige.class.getName()).log(Level.SEVERE, null, ex);
            }
        }


    }//GEN-LAST:event_cmbClanItemStateChanged

    private void btnVratiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVratiActionPerformed

        int selectedRow = tabelaZaduzenja.getSelectedRow();
        if (selectedRow != -1) {
            try {
                Clan clan = (Clan) cmbClan.getSelectedItem();
                if (((ZaduzenjeTableModel) tabelaZaduzenja.getModel()).getZaduzenja().get(selectedRow).getDatumVracanjaKnjige() == null) {
                    Controller.getInstance().izmeniZaduzenje(((ZaduzenjeTableModel) tabelaZaduzenja.getModel()).getZaduzenja().get(selectedRow));
                    JOptionPane.showMessageDialog(this, "Uspesno izmenjeno zaduzenje!");
                    ArrayList<Zaduzenje> zaduzenjaClana = Controller.getInstance().vratiZaduzenjaClana(clan.getId());
                    ArrayList<Knjiga> knjige = Controller.getInstance().vratiSveKnjige();

                    ((ZaduzenjeTableModel) tabelaZaduzenja.getModel()).setZaduzenja(zaduzenjaClana, knjige);
                } else {
                    JOptionPane.showMessageDialog(this, "Izabrani primerak je vracen!");
                }

            } catch (SocketException e) {
                JOptionPane.showConfirmDialog(this, "Server nije pokrenut !", "Greska", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            } catch (Exception ex) {
                Logger.getLogger(FVracanjeKnjige.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Izaberite iz liste primerak koji zelite da vratite");
        }

    }//GEN-LAST:event_btnVratiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVrati;
    private javax.swing.JComboBox cmbClan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaZaduzenja;
    // End of variables declaration//GEN-END:variables

    private void prepareForm() {
        setLocationRelativeTo(null);

        ZaduzenjeTableModel ztm = new ZaduzenjeTableModel();
        tabelaZaduzenja.setModel(ztm);

        cmbClan.removeAllItems();
        cmbClan.removeAllItems();
        ArrayList<Clan> listClanovi = new ArrayList<>();
        try {
            listClanovi = Controller.getInstance().vratiSveClanove();
        } catch (SocketException e) {
            JOptionPane.showConfirmDialog(this, "Server nije pokrenut !", "Greska", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (Exception ex) {
            Logger.getLogger(FUnosNovogZaduzenja.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (Clan clan : listClanovi) {
            cmbClan.addItem(clan);
        }

    }
}

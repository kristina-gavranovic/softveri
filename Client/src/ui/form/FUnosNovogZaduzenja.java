
package ui.form;

import controller.Controller;
import domain.Clan;
import domain.Knjiga;
import domain.Radnik;
import domain.Zaduzenje;

import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ui.component.table.model.PrimerakTableModel;
import util.StatusPrimerka;


public class FUnosNovogZaduzenja extends javax.swing.JFrame {

    Radnik ulogovaniRdanik;
    Knjiga knjiga;

    public FUnosNovogZaduzenja( Radnik ulogovaniRadnik, Knjiga knjiga) {
        initComponents();
        prepareForm(ulogovaniRadnik, knjiga);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblKnjiga = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPrimerak = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cmbClan = new javax.swing.JComboBox();
        btnSacuvajZaduzenje = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Unos novog zaduzenja", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(255, 0, 204))); // NOI18N

        lblKnjiga.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N

        jLabel1.setText("Izaberite primerak navedene knjige:");

        tabelaPrimerak.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaPrimerak);

        jLabel2.setText("Izaberite clana:");

        cmbClan.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnSacuvajZaduzenje.setText("Sacuvaj zaduzenje");
        btnSacuvajZaduzenje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajZaduzenjeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 482, Short.MAX_VALUE)
                        .addComponent(lblKnjiga, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnSacuvajZaduzenje, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                            .addComponent(cmbClan, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblKnjiga, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbClan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(btnSacuvajZaduzenje)
                .addGap(39, 39, 39))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
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

    private void btnSacuvajZaduzenjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajZaduzenjeActionPerformed

        Zaduzenje zaduzenje = new Zaduzenje();
        int selectedRow = tabelaPrimerak.getSelectedRow();
        if (selectedRow >= 0) {

            zaduzenje.setPrimerak(((PrimerakTableModel) tabelaPrimerak.getModel()).getPrimerci().get(selectedRow));
            if (zaduzenje.getPrimerak().getStatus()==StatusPrimerka.izdata) {
                JOptionPane.showMessageDialog(this, "Taj primerak je vec izdat, izerite drugi!");
                return;
            }
            zaduzenje.setRadnik(ulogovaniRdanik);
            zaduzenje.setClan((Clan) cmbClan.getSelectedItem());

            try {
                Controller.getInstance().sacuvajZaduzenje(zaduzenje);
                JOptionPane.showMessageDialog(this, "Sistem je uspesno zapamtio zaduzenje!");
                this.dispose();
            } catch (SocketException e) {
            JOptionPane.showConfirmDialog(this, "Server nije pokrenut !", "Greska", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (Exception ex) {
                Logger.getLogger(FUnosNovogZaduzenja.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            JOptionPane.showMessageDialog(this, "Izaberite primerak iz tabele!");
            return;

        }

    }//GEN-LAST:event_btnSacuvajZaduzenjeActionPerformed

    private void prepareForm(Radnik ulogovaniRadnik, Knjiga knjiga) {

        setLocationRelativeTo(null);

        this.ulogovaniRdanik = ulogovaniRadnik;
        this.knjiga = knjiga;
        lblKnjiga.setText("Izabrana knjiga je: " + knjiga.toString());
        PrimerakTableModel ptm = new PrimerakTableModel(knjiga);
        tabelaPrimerak.setModel(ptm);

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



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSacuvajZaduzenje;
    private javax.swing.JComboBox cmbClan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblKnjiga;
    private javax.swing.JTable tabelaPrimerak;
    // End of variables declaration//GEN-END:variables
}

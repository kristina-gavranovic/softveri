package ui.form;

import controller.Controller;
import domain.Knjiga;
import domain.Radnik;
import java.io.IOException;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ui.component.table.model.KnjigaTableModel;

public class FPretragaKnjiga extends javax.swing.JFrame {

    Radnik ulogovaniRadnik;

    public FPretragaKnjiga(java.awt.Frame parent, Radnik ulogovaniRadnik, ViewMode mode) {
        initComponents();
        prepareForm(ulogovaniRadnik, mode);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtPretraga = new javax.swing.JTextField();
        btnPronadji = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaPretraga = new javax.swing.JTable();
        btnZaduzi = new javax.swing.JButton();
        btnPrikazi = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Pretraga knjiga", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(204, 0, 204))); // NOI18N

        jLabel1.setText("Unesite deo naslova ili imena autora :");

        btnPronadji.setText("Pronadji");
        btnPronadji.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPronadjiActionPerformed(evt);
            }
        });

        tabelaPretraga.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tabelaPretraga);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 746, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(34, 34, 34)
                        .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(btnPronadji, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtPretraga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnPronadji))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnZaduzi.setText("Zaduzi");
        btnZaduzi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZaduziActionPerformed(evt);
            }
        });

        btnPrikazi.setText("Prikazi");
        btnPrikazi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrikaziActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnPrikazi, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addComponent(btnZaduzi, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(btnObrisi, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnZaduzi)
                    .addComponent(btnPrikazi)
                    .addComponent(btnObrisi))
                .addGap(0, 30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnPronadjiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPronadjiActionPerformed

        KnjigaTableModel model = (KnjigaTableModel) tabelaPretraga.getModel();

        try {
            ArrayList<Knjiga> listaKnjiga = Controller.getInstance().pronadjiKnjige(txtPretraga.getText().trim());
            model.setKnjige(listaKnjiga);
            model.fireTableDataChanged();

        } catch (SocketException e) {
            JOptionPane.showConfirmDialog(this, "Server nije pokrenut !", "Greska", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (Exception ex) {
            model.setKnjige(new ArrayList<>());
            model.fireTableDataChanged();
            JOptionPane.showConfirmDialog(this, ex.getMessage(), "Greska", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FPretragaKnjiga.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnPronadjiActionPerformed

    private void btnZaduziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnZaduziActionPerformed

        int rowIndex = tabelaPretraga.getSelectedRow();
        if (rowIndex >= 0) {
            try {
                KnjigaTableModel model = (KnjigaTableModel) tabelaPretraga.getModel();
                
                ArrayList<Knjiga> listaKnjiga = Controller.getInstance().pronadjiKnjige(txtPretraga.getText().trim());
                model.setKnjige(listaKnjiga);
                model.fireTableDataChanged();
                
                
                Knjiga izabranaKnjiga = ((KnjigaTableModel) tabelaPretraga.getModel()).getKnjige().get(rowIndex);
                new FUnosNovogZaduzenja(ulogovaniRadnik, izabranaKnjiga).setVisible(true);
                
             
            } catch (IOException ex) {
                Logger.getLogger(FPretragaKnjiga.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(FPretragaKnjiga.class.getName()).log(Level.SEVERE, null, ex);
            }

            
        } else {
            JOptionPane.showMessageDialog(this, "Izaberite knjigu koju zelite da zaduzite!");
        }

    }//GEN-LAST:event_btnZaduziActionPerformed

    private void btnPrikaziActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrikaziActionPerformed

        int rowIndex = tabelaPretraga.getSelectedRow();
        if (rowIndex >= 0) {
            Knjiga knjiga = ((KnjigaTableModel) tabelaPretraga.getModel()).getKnjige().get(rowIndex);
            new FPrikazKnjige(knjiga).setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Izaberite knjigu koju zelite da pregledate!");
        }

    }//GEN-LAST:event_btnPrikaziActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        // TODO add your handling code here:
         int rowIndex = tabelaPretraga.getSelectedRow();
        if (rowIndex >= 0) {
            Knjiga knjiga = ((KnjigaTableModel) tabelaPretraga.getModel()).getKnjige().get(rowIndex);
             try {
                 Controller.getInstance().obrisiKnjigu(knjiga);
             } catch (IOException ex) {
                 JOptionPane.showMessageDialog(this, ex.getMessage());
                 Logger.getLogger(FPretragaKnjiga.class.getName()).log(Level.SEVERE, null, ex);
             } catch (Exception ex) {
                   JOptionPane.showMessageDialog(this, ex.getMessage());
                 Logger.getLogger(FPretragaKnjiga.class.getName()).log(Level.SEVERE, null, ex);
             }
        } else {
            JOptionPane.showMessageDialog(this, "Izaberite knjigu koju zelite da obrisete!");
        }
        
    }//GEN-LAST:event_btnObrisiActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnPrikazi;
    private javax.swing.JButton btnPronadji;
    private javax.swing.JButton btnZaduzi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaPretraga;
    private javax.swing.JTextField txtPretraga;
    // End of variables declaration//GEN-END:variables

    private void prepareForm(Radnik ulogovaniRadnik, ViewMode mode) {
        this.ulogovaniRadnik = ulogovaniRadnik;
        this.setTitle("Pretraga knjiga");
        setLocationRelativeTo(null);

        KnjigaTableModel model = new KnjigaTableModel();
        tabelaPretraga.setModel(model);
        try {
            ArrayList<Knjiga> listaKnjiga = Controller.getInstance().pronadjiKnjige("");
            model.setKnjige(listaKnjiga);
            model.fireTableDataChanged();

        } catch (SocketException e) {
            JOptionPane.showConfirmDialog(this, "Server nije pokrenut !", "Greska", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            Logger.getLogger(FPretragaKnjiga.class.getName()).log(Level.SEVERE, null, ex);
        }

        switch (mode) {
            case PRETRAGA:
                btnZaduzi.setVisible(false);
                btnObrisi.setVisible(false);
                break;

            case ZADUZIVANJE:
                btnZaduzi.setEnabled(true);
                btnObrisi.setVisible(false);
                btnPrikazi.setVisible(false);
                break;
                
            case BRISANJE:
                btnZaduzi.setVisible(false);
               // btnPrikazi.setVisible(false);
                
                break;
            
            

        }

    }
}

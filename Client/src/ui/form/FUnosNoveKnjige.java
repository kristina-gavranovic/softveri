package ui.form;

import controller.Controller;
import domain.Autor;
import domain.Knjiga;
import domain.Primerak;

import java.net.SocketException;
import util.ZanrKnjige;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import ui.component.table.model.AutorTableModel;
import ui.component.table.model.PrimerakTableModel;
import ui.form_validation.KnjigaFormValidation;

public class FUnosNoveKnjige extends javax.swing.JDialog {

    public FUnosNoveKnjige(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        vratiSveAutore();
        vratiSveZanrove();
        postaviModelTabele();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNaslov = new javax.swing.JTextField();
        cmbZanr = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtOpis = new javax.swing.JTextArea();
        cmbAutor = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        txtISBN = new javax.swing.JTextField();
        btnDodajAutora = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaAutori = new javax.swing.JTable();
        btnUkloniAutora = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtIzdavac = new javax.swing.JTextField();
        txtGodinaIzdavanja = new javax.swing.JTextField();
        btnDodajPrimerak = new javax.swing.JButton();
        btnSacuvaj = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaPrimeraka = new javax.swing.JTable();
        btnUkloniPrimerak = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Podaci o knjizi", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(255, 0, 255))); // NOI18N

        jLabel1.setText("Naslov:");

        jLabel2.setText("Autor:");

        jLabel3.setText("Zanr:");

        jLabel4.setText("Opis:");

        cmbZanr.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtOpis.setColumns(20);
        txtOpis.setRows(5);
        jScrollPane1.setViewportView(txtOpis);

        cmbAutor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("ISBN:");

        btnDodajAutora.setText("Dodaj autora");
        btnDodajAutora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajAutoraActionPerformed(evt);
            }
        });

        tabelaAutori.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(tabelaAutori);

        btnUkloniAutora.setText("Ukolni autora");
        btnUkloniAutora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUkloniAutoraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNaslov)
                        .addGap(451, 451, 451))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbZanr, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel5)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(cmbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, 293, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnDodajAutora, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(btnUkloniAutora)))
                        .addContainerGap(144, Short.MAX_VALUE))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNaslov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbZanr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtISBN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cmbAutor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnDodajAutora)
                        .addComponent(btnUkloniAutora)))
                .addGap(28, 28, 28)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Podaci o primerku knjige", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 13), new java.awt.Color(255, 0, 255))); // NOI18N

        jLabel6.setText("Izdavac:");

        jLabel7.setText("Godina izdavanja:");

        btnDodajPrimerak.setText("Dodaj primerak");
        btnDodajPrimerak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajPrimerakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtIzdavac))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtGodinaIzdavanja, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(btnDodajPrimerak, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtIzdavac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(btnDodajPrimerak)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGodinaIzdavanja, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnSacuvaj.setText("Sacuvaj knjigu i njene primerke");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        tabelaPrimeraka.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tabelaPrimeraka);

        btnUkloniPrimerak.setText("Ukloni primerak");
        btnUkloniPrimerak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUkloniPrimerakActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btnUkloniPrimerak, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(154, 154, 154)
                                    .addComponent(btnSacuvaj, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(116, 116, 116)))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 597, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnUkloniPrimerak))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajPrimerakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajPrimerakActionPerformed
        PrimerakTableModel model = (PrimerakTableModel) tabelaPrimeraka.getModel();
        try {
            Primerak primerak = new Primerak(txtIzdavac.getText().trim(), Integer.valueOf(txtGodinaIzdavanja.getText().trim()));

            KnjigaFormValidation.validatePrimerak(primerak);
            model.dodajPrimerak(primerak);

        }
        catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Unesite godinu izdavnja kao broj!");
            Logger.getLogger(FUnosNoveKnjige.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
            Logger.getLogger(FUnosNoveKnjige.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDodajPrimerakActionPerformed

    private void btnUkloniPrimerakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUkloniPrimerakActionPerformed

        PrimerakTableModel model = (PrimerakTableModel) tabelaPrimeraka.getModel();
        int rowIndex = tabelaPrimeraka.getSelectedRow();
        if (rowIndex >= 0) {
            model.ukloniPrimerak(rowIndex);

        } else {
            JOptionPane.showMessageDialog(this, "Izaberite iz tabele primerak koji zelite da uklonite!");
        }
    }//GEN-LAST:event_btnUkloniPrimerakActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed

        PrimerakTableModel model = (PrimerakTableModel) tabelaPrimeraka.getModel();
        AutorTableModel modelAutora = (AutorTableModel) tabelaAutori.getModel();

        Knjiga knjigaSaForme = ((PrimerakTableModel) tabelaPrimeraka.getModel()).getKnjiga();
        knjigaSaForme.setAutori(modelAutora.getAutori());
        knjigaSaForme.setIsbn(txtISBN.getText());
        knjigaSaForme.setNaslov(txtNaslov.getText());
        knjigaSaForme.setOpis(txtOpis.getText());
        knjigaSaForme.setZanr(ZanrKnjige.valueOf(cmbZanr.getSelectedItem().toString()));

        try {
            KnjigaFormValidation.validateKnjiga(knjigaSaForme);
            if (!model.getPrimerci().isEmpty()) {
                Controller.getInstance().sacuvajKnjigu(knjigaSaForme);
                JOptionPane.showMessageDialog(this, "Uspesno su uneti podaci o novoj knjizi.");
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Morate uneti bar jedan primerak knjige!");
            }
        } catch (SocketException e) {
            JOptionPane.showConfirmDialog(this, "Server nije pokrenut !", "Greska", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
             System.exit(0);
        
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(this, ex.getMessage(), "Greska", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FUnosNoveKnjige.class.getName()).log(Level.SEVERE, null, ex);
        }


    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void btnDodajAutoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajAutoraActionPerformed
        Autor autor = (Autor) cmbAutor.getSelectedItem();
        AutorTableModel model = (AutorTableModel) tabelaAutori.getModel();
        if(!model.getAutori().contains(autor)){
        model.getAutori().add(autor);
        model.fireTableDataChanged();}
        else JOptionPane.showMessageDialog(this, "Izabrani autor je vec dodat!");

    }//GEN-LAST:event_btnDodajAutoraActionPerformed

    private void btnUkloniAutoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUkloniAutoraActionPerformed
        AutorTableModel model = (AutorTableModel) tabelaAutori.getModel();
        int rowIndex = tabelaAutori.getSelectedRow();
        if (rowIndex >= 0) {
            model.getAutori().remove(rowIndex);
            model.fireTableDataChanged();

        } else {
            JOptionPane.showMessageDialog(this, "Izaberite iz tabele autora kog zelite da uklonite!");
        }
    }//GEN-LAST:event_btnUkloniAutoraActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodajAutora;
    private javax.swing.JButton btnDodajPrimerak;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JButton btnUkloniAutora;
    private javax.swing.JButton btnUkloniPrimerak;
    private javax.swing.JComboBox cmbAutor;
    private javax.swing.JComboBox cmbZanr;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelaAutori;
    private javax.swing.JTable tabelaPrimeraka;
    private javax.swing.JTextField txtGodinaIzdavanja;
    private javax.swing.JTextField txtISBN;
    private javax.swing.JTextField txtIzdavac;
    private javax.swing.JTextField txtNaslov;
    private javax.swing.JTextArea txtOpis;
    // End of variables declaration//GEN-END:variables

    private void vratiSveAutore() {
        try {
            cmbAutor.removeAllItems();
            ArrayList<Autor> autori = (ArrayList<Autor>) Controller.getInstance().vratiSveAutore();
            for (Autor a : autori) {
                System.out.println("ucitan autor"+a.toString());
                cmbAutor.addItem(a);
            }
        } catch (Exception ex) {
            JOptionPane.showConfirmDialog(this, ex.getMessage(), "Greska", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(FUnosNoveKnjige.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void vratiSveZanrove() {
        cmbZanr.removeAllItems();
        
        for (ZanrKnjige value : ZanrKnjige.values()) {
          cmbZanr.addItem(value);
        }

    }

    private void postaviModelTabele() {
        PrimerakTableModel model = new PrimerakTableModel(new Knjiga());
        tabelaPrimeraka.setModel(model);

        AutorTableModel modelAutora = new AutorTableModel();
        tabelaAutori.setModel(modelAutora);

    }
}

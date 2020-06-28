package ui.form;

import domain.Radnik;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FMain extends javax.swing.JFrame {

    Radnik ulogovaniRadnik;

    public FMain(Radnik ulogovani) {
        initComponents();
        prepareForm(ulogovani);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        btnNovoZaduzenje = new javax.swing.JButton();
        btnVracanjeKnjige = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblUlogovaniRadnik = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuKnjige = new javax.swing.JMenu();
        jMenuItemKnjigeNova = new javax.swing.JMenuItem();
        jMenuItemKnjigePretraga = new javax.swing.JMenuItem();
        jMenuItemObrisiKnjigu = new javax.swing.JMenuItem();
        jmenuClan = new javax.swing.JMenu();
        jmenuItemClanNovi = new javax.swing.JMenuItem();
        jMenuRadnik = new javax.swing.JMenu();
        jMenuItemRadnikNovi = new javax.swing.JMenuItem();

        jMenu1.setText("jMenu1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Izaberite sta zelite da uradite");
        setBackground(new java.awt.Color(255, 102, 255));

        btnNovoZaduzenje.setBackground(new java.awt.Color(255, 204, 204));
        btnNovoZaduzenje.setForeground(new java.awt.Color(153, 0, 153));
        btnNovoZaduzenje.setText("Novo zaduzenje");
        btnNovoZaduzenje.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoZaduzenjeActionPerformed(evt);
            }
        });

        btnVracanjeKnjige.setBackground(new java.awt.Color(255, 204, 204));
        btnVracanjeKnjige.setForeground(new java.awt.Color(153, 0, 153));
        btnVracanjeKnjige.setText("Vracanje knjige");
        btnVracanjeKnjige.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVracanjeKnjigeActionPerformed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kristina\\Desktop\\kk.jpg")); // NOI18N

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\Kristina\\Desktop\\oo.jpg")); // NOI18N

        jLabel3.setText("Trenutno ulogovan radnik:");

        jMenuBar.setForeground(new java.awt.Color(204, 0, 204));

        jMenuKnjige.setText("Knjiga");

        jMenuItemKnjigeNova.setText("Unos nove knjige");
        jMenuItemKnjigeNova.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemKnjigeNovaActionPerformed(evt);
            }
        });
        jMenuKnjige.add(jMenuItemKnjigeNova);

        jMenuItemKnjigePretraga.setText("Pretraga knjiga");
        jMenuItemKnjigePretraga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemKnjigePretragaActionPerformed(evt);
            }
        });
        jMenuKnjige.add(jMenuItemKnjigePretraga);

        jMenuItemObrisiKnjigu.setText("Obrisi knjigu");
        jMenuItemObrisiKnjigu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemObrisiKnjiguActionPerformed(evt);
            }
        });
        jMenuKnjige.add(jMenuItemObrisiKnjigu);

        jMenuBar.add(jMenuKnjige);

        jmenuClan.setText("Novi clan");

        jmenuItemClanNovi.setText("Unos novog clana");
        jmenuItemClanNovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuItemClanNoviActionPerformed(evt);
            }
        });
        jmenuClan.add(jmenuItemClanNovi);

        jMenuBar.add(jmenuClan);

        jMenuRadnik.setText("Novi radnik");

        jMenuItemRadnikNovi.setText("Unos novog radnika");
        jMenuItemRadnikNovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItemRadnikNoviActionPerformed(evt);
            }
        });
        jMenuRadnik.add(jMenuItemRadnikNovi);

        jMenuBar.add(jMenuRadnik);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(btnNovoZaduzenje, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVracanjeKnjige, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(100, 100, 100))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(45, 45, 45))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblUlogovaniRadnik, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoZaduzenje, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVracanjeKnjige, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblUlogovaniRadnik)
                    .addComponent(jLabel3))
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemKnjigePretragaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemKnjigePretragaActionPerformed

        FPretragaKnjiga form = new FPretragaKnjiga(this, ulogovaniRadnik, ViewMode.PRETRAGA);
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItemKnjigePretragaActionPerformed

    private void jMenuItemKnjigeNovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemKnjigeNovaActionPerformed

        try {
            FUnosNoveKnjige form = new FUnosNoveKnjige(this, true);
            form.setVisible(true);
        } catch (Exception ex) {
            Logger.getLogger(FMain.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jMenuItemKnjigeNovaActionPerformed

    private void jmenuItemClanNoviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmenuItemClanNoviActionPerformed
        FUnosNovogClana form = new FUnosNovogClana(this, true);
        form.setVisible(true);
    }//GEN-LAST:event_jmenuItemClanNoviActionPerformed

    private void jMenuItemRadnikNoviActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemRadnikNoviActionPerformed
        FUnosNovogRadnika form = new FUnosNovogRadnika();
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItemRadnikNoviActionPerformed

    private void btnNovoZaduzenjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoZaduzenjeActionPerformed
        FPretragaKnjiga form = new FPretragaKnjiga(this, ulogovaniRadnik, ViewMode.ZADUZIVANJE);
        form.setVisible(true);
    }//GEN-LAST:event_btnNovoZaduzenjeActionPerformed

    private void btnVracanjeKnjigeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVracanjeKnjigeActionPerformed
        FVracanjeKnjige form = new FVracanjeKnjige();
        form.setVisible(true);
    }//GEN-LAST:event_btnVracanjeKnjigeActionPerformed

    private void jMenuItemObrisiKnjiguActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemObrisiKnjiguActionPerformed
        // TODO add your handling code here:
        
        FPretragaKnjiga form=new FPretragaKnjiga(this, ulogovaniRadnik, ViewMode.BRISANJE);
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItemObrisiKnjiguActionPerformed

//    public Radnik getUlogovaniRadnik() {
//        return ulogovaniRadnik;
//    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovoZaduzenje;
    private javax.swing.JButton btnVracanjeKnjige;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItemKnjigeNova;
    private javax.swing.JMenuItem jMenuItemKnjigePretraga;
    private javax.swing.JMenuItem jMenuItemObrisiKnjigu;
    private javax.swing.JMenuItem jMenuItemRadnikNovi;
    private javax.swing.JMenu jMenuKnjige;
    private javax.swing.JMenu jMenuRadnik;
    private javax.swing.JMenu jmenuClan;
    private javax.swing.JMenuItem jmenuItemClanNovi;
    private javax.swing.JLabel lblUlogovaniRadnik;
    // End of variables declaration//GEN-END:variables

    private void prepareForm(Radnik ulogovani) {
        ulogovaniRadnik = ulogovani;
        lblUlogovaniRadnik.setText(ulogovaniRadnik.toString());
        setLocationRelativeTo(null);
    }

}

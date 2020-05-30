/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.form;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student1
 */
public class FMain extends javax.swing.JFrame {

    /**
     * Creates new form FMain
     */
    public FMain() {
        initComponents();

        setLocationRelativeTo(null);
       
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnNovoZaduzenje = new javax.swing.JButton();
        btnVracanjeKnjige = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar = new javax.swing.JMenuBar();
        jMenuKnjige = new javax.swing.JMenu();
        jMenuItemKnjigeNova = new javax.swing.JMenuItem();
        jMenuItemKnjigePretraga = new javax.swing.JMenuItem();
        jmenuClan = new javax.swing.JMenu();
        jmenuItemClanNovi = new javax.swing.JMenuItem();
        jMenuRadnik = new javax.swing.JMenu();
        jMenuItemRadnikNovi = new javax.swing.JMenuItem();

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

        jMenuBar.setForeground(new java.awt.Color(204, 0, 204));

        jMenuKnjige.setText("Knjige");

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

        jMenuBar.add(jMenuKnjige);

        jmenuClan.setText("Clan");

        jmenuItemClanNovi.setText("Unos novog clana");
        jmenuItemClanNovi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmenuItemClanNoviActionPerformed(evt);
            }
        });
        jmenuClan.add(jmenuItemClanNovi);

        jMenuBar.add(jmenuClan);

        jMenuRadnik.setText("Radnik");

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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btnNovoZaduzenje, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnVracanjeKnjige, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(53, 53, 53)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnNovoZaduzenje, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVracanjeKnjige, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItemKnjigePretragaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemKnjigePretragaActionPerformed
       
        FPretragaKnjiga form=new FPretragaKnjiga(this, true);

        form.setVisible(true);
    }//GEN-LAST:event_jMenuItemKnjigePretragaActionPerformed

    private void jMenuItemKnjigeNovaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItemKnjigeNovaActionPerformed
        
        try {
             FUnosNoveKnjige form=new FUnosNoveKnjige(this, true);
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
        // TODO add your handling code here:
        FUnosNovogRadnika form=new FUnosNovogRadnika(this, true);
        form.setVisible(true);
    }//GEN-LAST:event_jMenuItemRadnikNoviActionPerformed

    private void btnNovoZaduzenjeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoZaduzenjeActionPerformed
        // TODO add your handling code here:
        FUnosNovogZaduzenja form=new FUnosNovogZaduzenja(this, true);
        form.setVisible(true);
    }//GEN-LAST:event_btnNovoZaduzenjeActionPerformed

    private void btnVracanjeKnjigeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVracanjeKnjigeActionPerformed
        // TODO add your handling code here:
        FVracanjeKnjige form=new FVracanjeKnjige(this, false);
        form.setVisible(true);
    }//GEN-LAST:event_btnVracanjeKnjigeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNovoZaduzenje;
    private javax.swing.JButton btnVracanjeKnjige;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenuItem jMenuItemKnjigeNova;
    private javax.swing.JMenuItem jMenuItemKnjigePretraga;
    private javax.swing.JMenuItem jMenuItemRadnikNovi;
    private javax.swing.JMenu jMenuKnjige;
    private javax.swing.JMenu jMenuRadnik;
    private javax.swing.JMenu jmenuClan;
    private javax.swing.JMenuItem jmenuItemClanNovi;
    // End of variables declaration//GEN-END:variables
}

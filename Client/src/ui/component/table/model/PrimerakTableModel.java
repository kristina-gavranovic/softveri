/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.component.table.model;

import domain.Knjiga;
import domain.Primerak;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kristina
 */
public class PrimerakTableModel extends AbstractTableModel {

    private Knjiga knjiga;
    private String[] columnNames = new String[]{"Izdavac", "Godina izdavanja"};

    public PrimerakTableModel(Knjiga knjiga) {
        this.knjiga = knjiga;

    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    @Override
    public int getRowCount() {
        if (knjiga != null) {
            return knjiga.getPrimerci().size();
        }
        return 0;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Primerak p = knjiga.getPrimerci().get(rowIndex);
        switch (columnIndex) {
            case 0:
                return p.getIzdavac();
            case 1:
                return p.getGodinaIzdavanja();

            default:
                return "Greska!";
        }
    }

    public void dodajPrimerak(String izdavac, int godinaIzdavanja) {
        Primerak primerak = new Primerak();
        primerak.setGodinaIzdavanja(godinaIzdavanja);
        primerak.setIzdavac(izdavac);
        primerak.setStatus("slobodna");
        primerak.setRbr(-1);
        knjiga.getPrimerci().add(primerak);
        fireTableDataChanged();

    }

    public void ukloniPrimerak(int index) {
        knjiga.getPrimerci().remove(index);
        fireTableDataChanged();

    }

    public ArrayList<Primerak> getPrimerci() {
        return (ArrayList<Primerak>) knjiga.getPrimerci();
    }

}

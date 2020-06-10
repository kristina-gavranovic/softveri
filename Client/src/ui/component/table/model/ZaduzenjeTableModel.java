/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.component.table.model;

import domain.Knjiga;
import domain.Zaduzenje;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kristina
 */
public class ZaduzenjeTableModel extends AbstractTableModel {

    private ArrayList<Zaduzenje> zaduzenja;
    private ArrayList<Knjiga> knjige;
    private String[] columnNames = new String[]{"Naslov", "Izdavac", "Datum uzimanja  knjige", "Datum vracanja knjige"};

    public ArrayList<Zaduzenje> getZaduzenja() {
        return zaduzenja;
    }

    public void setZaduzenja(ArrayList<Zaduzenje> zaduzenja, ArrayList<Knjiga> knjige) {
        this.zaduzenja = zaduzenja;
        this.knjige = knjige;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return zaduzenja.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Zaduzenje zaduzenje = zaduzenja.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return vratiNaslov(zaduzenje.getPrimerak().getKnjigaId());

            case 1:
                return zaduzenje.getPrimerak().getIzdavac().toString();
            case 2:
                return zaduzenje.getDatumUzimanjaKnjige().toString();

            case 3:
                if (zaduzenje.getDatumVracanjaKnjige() == null) {
                    return "Nije vracena";
                }
                return zaduzenje.getDatumVracanjaKnjige().toString();

            default:
                return "Greska";

        }
    }

    private String vratiNaslov(Integer id) {
        for (Knjiga k : knjige) {
            if (k.getId() == id) {
                return k.getNaslov();
            }
        }
        return "Greska";
    }

}

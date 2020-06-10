/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.component.table.model;

import domain.Zaduzenje;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kristina
 */
public class ZaduzenjeTableModel extends AbstractTableModel {

    private ArrayList<Zaduzenje> zaduzenja;
    private String[] columnNames = new String[]{"Naslov", "Datum uzimanja  knjige", "Datum vracanja knjige", "Opis"};

    public ArrayList<Zaduzenje> getZaduzenja() {
        return zaduzenja;
    }

    public void setZaduzenja(ArrayList<Zaduzenje> zaduzenja) {
        this.zaduzenja = zaduzenja;
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
        
        //{"Naziv", "Autor/i", "Zanr", "ISBN", "Izdavac", "Godina izdavanja", "Satus"
        switch (columnIndex) {
            case 0: return zaduzenje.getDatumUzimanjaKnjige().toString();
            
            case 1:
                if(zaduzenje.getDatumVracanjaKnjige() ==null)return "Nije vracena";
                    return zaduzenje.getDatumVracanjaKnjige().toString();
                
            //case 2: return knjiga.getIsbn();
            //case 3: return knjiga.getOpis();
            

              
            default: return  "Greska";
                
        }    }

}

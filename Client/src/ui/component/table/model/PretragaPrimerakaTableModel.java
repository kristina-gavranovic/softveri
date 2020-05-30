/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.component.table.model;

import domain.Primerak;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kristina
 */
public class PretragaPrimerakaTableModel extends AbstractTableModel {

    private ArrayList<Primerak> primerci;
    private String[] columnNames = new String[]{"Naziv", "Zanr", "ISBN", "Izdavac", "Godina izdavanja", "Satus"};

    public PretragaPrimerakaTableModel() {
        primerci = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return primerci.size();
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
        Primerak primerak = primerci.get(rowIndex);
        
        //{"Naziv", "Autor/i", "Zanr", "ISBN", "Izdavac", "Godina izdavanja", "Satus"
        switch (columnIndex) {
            case 0: return primerak.getNaslov();
            
            case 1:return primerak.getZanr();
            case 2: return primerak.getIsbn();
            case 3: return primerak.getIzdavac();
            case 4: return primerak.getGodinaIzdavanja();
            case 5: return primerak.getStatus();

              
            default: return  "Greska";
                
        }
    }

    public ArrayList<Primerak> getPrimerci() {
        return primerci;
    }

    public void setPrimerci(ArrayList<Primerak> primerci) {
        this.primerci = primerci;
    }
    
    

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.component.table.model;

import domain.Autor;
import domain.Knjiga;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kristina
 */
public class KnjigaTableModel extends AbstractTableModel {

    private ArrayList<Knjiga> knjige;
    private String[] columnNames = new String[]{"Naslov", "Autori", "ISBN", "Opis"};

    public KnjigaTableModel() {
        knjige = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return knjige.size();
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
        Knjiga knjiga = knjige.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return knjiga.getNaslov();

            case 1:
                return knjiga.autoriToString((ArrayList<Autor>) knjiga.getAutori());
            case 2:
                return knjiga.getIsbn();
            case 3:
                return knjiga.getOpis();

            default:
                return "Greska";

        }
    }

    public ArrayList<Knjiga> getKnjige() {
        return knjige;
    }

    public void setKnjige(ArrayList<Knjiga> knjige) {
        this.knjige = knjige;
    }

}

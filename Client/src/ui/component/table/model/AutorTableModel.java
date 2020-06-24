/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.component.table.model;

import domain.Autor;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Kristina
 */
public class AutorTableModel extends AbstractTableModel {

    private ArrayList<Autor> autori;
    private String[] columnNames = new String[]{"Ime", "Prezime"};

    public AutorTableModel() {
        this.autori = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return autori.size();
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
        Autor autor = autori.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return autor.getIme();
            case 1:
                return autor.getPrezime();

            default:
                return "Greska";

        }

    }

    public ArrayList<Autor> getAutori() {
        return autori;
    }

}


package ui.component.table.model;

import domain.Knjiga;
import domain.Primerak;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;


public class PrimerakTableModel extends AbstractTableModel {

    private Knjiga knjiga;
    private String[] columnNames = new String[]{"Izdavac", "Godina izdavanja", "Status"};

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
            case 2:
                return p.getStatus();

            default:
                return "Greska!";
        }
    }

    public void dodajPrimerak(Primerak primerak) {
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

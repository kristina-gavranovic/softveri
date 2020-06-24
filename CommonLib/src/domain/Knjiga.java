/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author krist
 */
public class Knjiga implements Serializable, IGeneralObject {

    protected Integer id;
    protected String naslov;
    protected String zanr;
    protected String opis;
    protected String isbn;
    protected List<Primerak> primerci;
    protected List<Autor> autori;

    public Knjiga() {
        this.primerci = new ArrayList<>();
        this.autori = new ArrayList<>();

    }

    public Knjiga(Integer id, String naslov, String zanr, String opis, String isbn) {
        this.id = id;
        this.naslov = naslov;
        this.zanr = zanr;
        this.opis = opis;
        this.isbn = isbn;

        this.primerci = new ArrayList<>();
        this.autori = new ArrayList<>();

    }

    Knjiga(Integer id) {
        this.id = id;
    }

    public List<Autor> getAutori() {
        return autori;
    }

    public void setAutori(List<Autor> autori) {
        this.autori = autori;
    }

    public List<Primerak> getPrimerci() {
        return primerci;
    }

    public void setPrimerci(List<Primerak> primerci) {
        this.primerci = primerci;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getZanr() {
        return zanr;
    }

    public void setZanr(String zanr) {
        this.zanr = zanr;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    @Override
    public String getTableName() {
        return "knjiga";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "naslov,zanr, isbn, opis";
    }

    @Override
    public String getInsertValues() {
        return new StringBuilder()
                .append("'")
                .append(this.naslov)
                .append("', '")
                .append(this.zanr)
                .append("', '")
                .append(this.isbn)
                .append("', '")
                .append(this.opis)
                .append("'")
                .toString();
    }

    @Override
    public IGeneralObject getObject(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getObjectCase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IGeneralObject> getList(ResultSet rs) throws SQLException {
        List<IGeneralObject> list = new ArrayList<>();

        while (rs.next()) {

            Knjiga knjiga = new Knjiga();
            knjiga.setId(rs.getInt("id"));
            knjiga.setIsbn(rs.getString("isbn"));
            knjiga.setNaslov(rs.getString("naslov"));
            knjiga.setZanr(rs.getString("zanr"));
            knjiga.setOpis(rs.getString("opis"));

            list.add(knjiga);

        }
        return list;
    }

    @Override
    public String getUpdateValues() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String toString() {
        return this.naslov;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String autoriToString(ArrayList<Autor> list) {
        String autori = "";
        if (!list.isEmpty()) {

            Autor last = list.get(list.size() - 1);

            for (Autor a : list) {
                if (last.equals(a)) {
                    autori += a.getIme() + " " + a.getPrezime();
                } else {
                    autori += a.getIme() + " " + a.getPrezime() + ", ";
                }
            }
            return autori;
        } else {
            return "Nepoznat autor";
        }

    }

}

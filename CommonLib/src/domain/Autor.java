/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author krist
 */
public class Autor implements Serializable, IGeneralObject {

    private Integer id;
    private String ime;
    private String prezime;
    private String zemljaPorekla;

    public Autor() {
    }

    public Autor(int id, String ime, String prezime, String zemljaPorekla) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.zemljaPorekla = zemljaPorekla;
    }

    public Autor(Integer id) {
        this.id=id;
    }

    public String getZemljaPorekla() {
        return zemljaPorekla;
    }

    public void setZemljaPorekla(String zemljaPorekla) {
        this.zemljaPorekla = zemljaPorekla;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.ime);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Autor other = (Autor) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String getTableName() {
        return "autor";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "ime, prezime, zemljaPorekla";
    }

    @Override
    public String getInsertValues() {
        return new StringBuilder()
                .append("'")
                .append(this.ime)
                .append("', ")
                .append(this.prezime)
                .append(", ")
                .append(this.zemljaPorekla)
                .toString();
    }

    @Override
    public IGeneralObject getObject(ResultSet rs) throws SQLException {
       
          if (rs.next()) {
             Autor autor = new Autor();
            autor.setId(rs.getInt("id"));
            autor.setIme(rs.getString("ime"));
            autor.setPrezime(rs.getString("prezime"));
            autor.setZemljaPorekla(rs.getString("zemljaPorekla"));
            return autor;
        }
        throw new SQLException("Sistem ne moze da pronadje autore!");
    }

    @Override
    public String getObjectCase() {
        return "id = " + this.getId();
    }

    @Override
    public List<IGeneralObject> getList(ResultSet rs) throws SQLException {
        List<IGeneralObject> list = new ArrayList<>();

        while (rs.next()) {

            Autor autor = new Autor();
            autor.setId(rs.getInt("id"));
            autor.setIme(rs.getString("ime"));
            autor.setPrezime(rs.getString("prezime"));
            autor.setZemljaPorekla(rs.getString("zemljaPorekla"));

            list.add(autor);

        }
        return list;
    }

    @Override
    public String getUpdateValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getId() {
        return this.id;
    }

}

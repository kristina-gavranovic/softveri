/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Kristina
 */
public class AutorKnjiga implements  Serializable, IGeneralObject{
    private Integer id;
    private Knjiga knjiga;
    private Autor autor;

    public AutorKnjiga() {
    }

    public AutorKnjiga(int id, Knjiga knjiga, Autor autor) {
        this.id = id;
        this.knjiga = knjiga;
        this.autor = autor;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Knjiga getKnjiga() {
        return knjiga;
    }

    public void setKnjiga(Knjiga knjiga) {
        this.knjiga = knjiga;
    }

    @Override
    public String getTableName() {
        return "autorknjiga";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "id, idKnjiga, idAutor";
    }

    @Override
    public String getInsertValues() {
         return new StringBuilder()
                .append("")
                .append(this.id)
                .append(", ")
                .append(this.knjiga.getId())
                .append(", ")
                .append(this.autor.getId())
                .append("")
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUpdateValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

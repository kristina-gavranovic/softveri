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

/**
 *
 * @author Kristina
 */
public class AutorKnjiga implements  Serializable, IGeneralObject{
    private Integer id;
    private Integer knjigaID;
    private Integer autorID;

    public AutorKnjiga() {
    }

    public AutorKnjiga(Integer id, Integer knjigaID, Integer autorID) {
        this.id = id;
        this.knjigaID = knjigaID;
        this.autorID = autorID;
    }

    public Integer getAutorID() {
        return autorID;
    }

    public void setAutorID(Integer autor) {
        this.autorID = autor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKnjigaID() {
        return knjigaID;
    }

    public void setKnjigaID(Integer knjigaID) {
        this.knjigaID = knjigaID;
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
                .append(this.knjigaID)
                .append(", ")
                .append(this.autorID)
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
         List<IGeneralObject> list = new ArrayList<>();
        
        while(rs.next()){
           
            AutorKnjiga autorKnjiga=new AutorKnjiga();
            autorKnjiga.setId(rs.getInt("id"));
            autorKnjiga.setAutorID(rs.getInt("idAutor"));
            autorKnjiga.setKnjigaID(rs.getInt("idKnjiga"));

           
            list.add(autorKnjiga);
            

        }
    return list;

        }

    @Override
    public String getUpdateValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setId(int id) {
              this.id = id;

    }
    
}

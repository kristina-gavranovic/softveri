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
 * @author krist
 */
public class Primerak implements Serializable, IGeneralObject {

    private Integer rbr;
    private String izdavac;
    private String status;
    private int godinaIzdavanja;
    private Integer knjigaId;

    public Primerak() {
    }

    public Primerak(int rbr, String izdavac, String status, int godinaIzdavanja, Integer knjigaId) {
        //super(id, naslov, zanr, opis, isbn);
        this.rbr = rbr;
        this.izdavac = izdavac;
        this.status = status;
        this.godinaIzdavanja = godinaIzdavanja;
        this.knjigaId = knjigaId;
    }

    Primerak(Integer rbr) {
        this.rbr = rbr;

    }

    public int getGodinaIzdavanja() {
        return godinaIzdavanja;
    }

    public void setGodinaIzdavanja(int godinaIzdavanja) {
        this.godinaIzdavanja = godinaIzdavanja;
    }

    public void setRbr(Integer rbr) {
        this.rbr = rbr;
    }

    public Integer getRbr() {
        return rbr;
    }

    public String getIzdavac() {
        return izdavac;
    }

    public void setIzdavac(String izdavac) {
        this.izdavac = izdavac;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getKnjigaId() {
        return knjigaId;
    }

    public void setKnjigaId(Integer knjigaId) {
        this.knjigaId = knjigaId;
    }

    @Override
    public String toString() {
        return this.izdavac;
        //  return super.getNaslov()+" "+this.getIzdavac();//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getTableName() {
        return "primerak";
        //return "primerak p JOIN biblioteka.knjiga k ON k.id=p.knjigaID ";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "izdavac, godinaIzdavanja, status, knjigaId";

    }

    @Override
    public String getInsertValues() {

        // System.out.println(super.getId());
        return new StringBuilder()
                .append("'")
                .append(this.izdavac)
                .append("', ")
                .append(this.godinaIzdavanja)
                .append(", '")
                .append(this.status)
                .append("', ")
                .append(this.knjigaId)
                .toString();

    }

    @Override
    public IGeneralObject getObject(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getObjectCase() {
        return "rbr = " + this.getRbr();

    }

    @Override
    public List<IGeneralObject> getList(ResultSet rs) throws SQLException {
        List<IGeneralObject> list = new ArrayList<>();

        while (rs.next()) {

            Primerak primerak = new Primerak();
            primerak.setRbr(rs.getInt("rbr"));
            primerak.setIzdavac(rs.getString("izdavac"));
            primerak.setStatus(rs.getString("status"));
            primerak.setGodinaIzdavanja(rs.getInt("godinaizdavanja"));
            primerak.setKnjigaId(rs.getInt("knjigaID"));

            list.add(primerak);

        }
        return list;
    }

    @Override
    public String getUpdateValues() {
        if (this.getStatus().equals("izdata")) 
            return new StringBuilder()
                    .append("status = '").append("slobodna").append("' ").toString();
        
            return new StringBuilder()
                    .append("status = '").append("izdata").append("' ").toString();

        }

    

    @Override
    public void setId(int id) {
        this.rbr = id;
    }

    @Override
    public Integer getId() {
        return rbr;
    }

}

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
import java.util.Date;
import java.util.List;

/**
 *
 * @author krist
 */
public class Zaduzenje implements Serializable, IGeneralObject {

    private Integer id;
    private Date datumUzimanjaKnjige;
    private Date datumVracanjaKnjige;

    private Primerak primerak;
    private Radnik radnik;
    private Clan clan;

    public Zaduzenje() {
    }

    public Zaduzenje(int id, Date datumUzimanjaKnjige, Date datumVracanjaKnjige, Primerak primerak, Radnik radnik) {
        this.id = id;
        this.datumUzimanjaKnjige = datumUzimanjaKnjige;
        this.datumVracanjaKnjige = datumVracanjaKnjige;

        this.primerak = primerak;
        this.radnik = radnik;
    }

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatumUzimanjaKnjige() {
        return datumUzimanjaKnjige;
    }

    public void setDatumUzimanjaKnjige(Date datumUzimanjaKnjige) {
        this.datumUzimanjaKnjige = datumUzimanjaKnjige;
    }

    public Date getDatumVracanjaKnjige() {
        return datumVracanjaKnjige;
    }

    public void setDatumVracanjaKnjige(Date datumVracanjaKnjige) {
        this.datumVracanjaKnjige = datumVracanjaKnjige;
    }

    public Primerak getPrimerak() {
        return primerak;
    }

    public void setPrimerak(Primerak primerak) {
        this.primerak = primerak;
    }

    public Radnik getRadnik() {
        return radnik;
    }

    public void setRadnik(Radnik radnik) {
        this.radnik = radnik;
    }
        public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    @Override
    public String getTableName() {
        return "zaduzenje";
    }

    @Override
    public String getColumnNamesForInsert() {
        return "datumUzimanjaKnjige, clanID, radnikID, rbrPrimerka";
    }

    @Override
    public String getInsertValues() {
        return new StringBuilder()
                .append("SYSDATE()")
                .append(", ")
                .append(this.getClan().getId())
                .append(", ")
                .append(this.getRadnik().getId())
                .append(", ")
                .append(this.getPrimerak().getId())
                .toString();

    }

    @Override
    public IGeneralObject getObject(ResultSet rs) throws SQLException {
           Zaduzenje zaduzenje = new Zaduzenje();
        //zaduzenje.setId(rs.getInt("id"));
       // zaduzenje.setDateCreated(rs.getDate("date_created"));
       // zaduzenje.setDescription(rs.getString("description"));
       // zaduzenje.setClient(new Client(rs.getInt("client_id")));
        //invoice.setEmployee(new Employee(rs.getInt("employee_id")));
        return zaduzenje;
    }

    @Override
    public String getObjectCase() {
             return "id = " + this.getId();
    }

    @Override
    public List<IGeneralObject> getList(ResultSet rs) throws SQLException {
                 List<IGeneralObject> list = new ArrayList<>();
        
        while(rs.next()){
            Zaduzenje zaduzenje = new Zaduzenje();
            
            zaduzenje.setId(rs.getInt("id"));
            zaduzenje.setDatumUzimanjaKnjige(rs.getDate("datumUzimanjaKnjige"));
            zaduzenje.setDatumVracanjaKnjige(rs.getDate("datumVracanjaKnjige"));
            zaduzenje.setClan(new Clan(rs.getInt("clanID")));
            zaduzenje.setRadnik(new Radnik(rs.getInt("radnikID")));
            zaduzenje.setPrimerak(new Primerak(rs.getInt("rbrPrimerka")));
            list.add(zaduzenje);
        }
        
        return list;

    }

    @Override
    public String getUpdateValues() {
         return new StringBuilder()
                .append("datumVracanjaKnjige = ").append("SYSDATE()").append(" ").toString();
    }

        


}

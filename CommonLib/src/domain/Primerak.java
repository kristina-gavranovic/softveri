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
public class Primerak extends Knjiga implements Serializable, IGeneralObject {
    private Integer rbr;
    private String izdavac;
    private String status;
    private int godinaIzdavanja;

    public Primerak() {
        super();
    }

    public Primerak(int rbr, String izdavac, String status, int godinaIzdavanja,Integer id, String naslov, String zanr, String opis, String isbn) {
        super(id, naslov, zanr, opis, isbn);
        this.rbr = rbr;
        this.izdavac = izdavac;
        this.status = status;
        this.godinaIzdavanja = godinaIzdavanja;
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

    public List<Primerak> getPrimerci() {
        return primerci;
    }

    public void setPrimerci(List<Primerak> primerci) {
        this.primerci = primerci;
    }

    public List<Autor> getAutori() {
        return autori;
    }

    public void setAutori(List<Autor> autori) {
        this.autori = autori;
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

   

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return super.getNaslov()+" "+this.getIzdavac();//To change body of generated methods, choose Tools | Templates.
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
        
        System.out.println(super.getId());
         return new StringBuilder()
                .append("'")
                .append(this.izdavac)
                .append("', ")
                .append(this.godinaIzdavanja)
                .append(", '")
                .append(this.status)
                .append("', ")
                .append(super.getId())
                .toString();


    }

    @Override
    public IGeneralObject getObject(ResultSet rs) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getObjectCase( ) {
       return " ";

    }

    @Override
    public List<IGeneralObject> getList(ResultSet rs) throws SQLException {
            List<IGeneralObject> list = new ArrayList<>();
        
        while(rs.next()){
           
            Primerak primerak=new Primerak();
            primerak.setRbr(rs.getInt("rbr"));
//            primerak.setIsbn(rs.getString("isbn"));
            primerak.setIzdavac(rs.getString("izdavac"));
            //primerak.setNaslov(rs.getString("naslov"));
            primerak.setStatus(rs.getString("status"));
           // primerak.setZanr(rs.getString("zanr"));
            //primerak.setOpis(rs.getString("opis"));
            primerak.setGodinaIzdavanja(rs.getInt("godinaizdavanja"));

           
            list.add(primerak);
            

        }
    return list;
    }

   

    @Override
    public String getUpdateValues() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

   
    
    
    
    
}

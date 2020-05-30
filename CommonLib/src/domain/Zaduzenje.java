/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author krist
 */
public class Zaduzenje implements Serializable{
    private int id;
    private Date datumUzimanjaKnjige;
    private Date datumVracanjaKnjige;
    
    private Primerak primerak;
    private Radnik radnik;

    public Zaduzenje() {
    }

    public Zaduzenje(int id, Date datumUzimanjaKnjige, Date datumVracanjaKnjige, Primerak primerak, Radnik radnik) {
        this.id = id;
        this.datumUzimanjaKnjige = datumUzimanjaKnjige;
        this.datumVracanjaKnjige = datumVracanjaKnjige;
        
        this.primerak = primerak;
        this.radnik = radnik;
    }

   

    public int getId() {
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
    
    
    
    
}

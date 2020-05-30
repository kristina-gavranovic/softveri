/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author krist
 */
public class Clan implements Serializable{
    private int id;
    private String ime;
    private String prezime;
    private String jmbg;
    private String telefon;
    private List<Zaduzenje> zaduzenja;

    public Clan() {
    }

    public Clan(int id, String ime, String prezime, String jmbg, String telefon) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.jmbg = jmbg;
        this.telefon = telefon;
        this.zaduzenja = new ArrayList<>();
    }

    public List<Zaduzenje> getZaduzenja() {
        return zaduzenja;
    }

    public void setZaduzenja(List<Zaduzenje> zaduzenja) {
        this.zaduzenja = zaduzenja;
    }
    
    public int getId() {
        return id;
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

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    @Override
    public String toString() {
        return this.ime+""+this.prezime; 
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Clan other = (Clan) obj;
        if (!Objects.equals(this.jmbg, other.jmbg)) {
            return false;
        }
        return true;
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author krist
 */
public class Knjiga implements Serializable {

    private int id;
    private String naslov;
    private String zanr;
    private String opis;
    private String isbn;
    private List<Primerak> primerci;
    private List<Autor> autori;

    public Knjiga() {
        this.primerci = new ArrayList<>();
        this.autori = new ArrayList<>();

    }

    public Knjiga(int id, String naslov, String zanr, String opis, String isbn, Autor autor, List<Primerak> primerci) {
        this.id = id;
        this.naslov = naslov;
        this.zanr = zanr;
        this.opis = opis;
        this.isbn = isbn;

        this.primerci = new ArrayList<>();
        this.autori = new ArrayList<>();

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

}

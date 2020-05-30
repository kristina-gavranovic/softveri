/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author krist
 */
public class Primerak extends Knjiga implements Serializable {
    private int rbr;
    private String izdavac;
    private String status;
    private int godinaIzdavanja;

    public Primerak() {
    }

    public Primerak(int rbr, String izdavac, String status, int godinaIzdavanja) {
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

    public int getRbr() {
        return rbr;
    }

    public void setRbr(int rbr) {
        this.rbr = rbr;
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
    
    
    
    
    
}

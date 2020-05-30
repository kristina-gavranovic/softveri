/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author student1
 */
public class Radnik implements Serializable {

    private int id;
    private String ime;
    private String prezime;
    private String username;
    private String password;
    private StatusRadnika status;

    public Radnik() {
    }

    public Radnik(int id, String ime, String prezime, String username, String password, StatusRadnika status) {
        this.id = id;
        this.ime = ime;
        this.prezime = prezime;
        this.username = username;
        this.password = password;
        this.status = status;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public StatusRadnika getStatus() {
        return status;
    }

    public void setStatus(StatusRadnika status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return this.ime + " " + this.prezime; 
    }

}

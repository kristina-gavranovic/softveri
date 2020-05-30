/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;

/**
 *
 * @author Kristina
 */
public class AutorKnjiga implements  Serializable{
    private int id;
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

    public int getId() {
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
    
}

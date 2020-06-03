/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Autor;
import domain.Clan;
import domain.Knjiga;
import domain.Primerak;
import domain.Radnik;
import java.util.List;
import service.so.impl.SOPronadjiPrimerke;
import service.so.impl.SOPronadjiRadnika;
import service.so.impl.SOSacuvajClana;
import service.so.impl.SOSacuvajKnjigu;
import service.so.impl.SOSacuvajRadnika;
import service.so.impl.SOVratiSveAutore;

/**
 *
 * @author Kristina
 */
public class Controller {

    private static Controller instance;

    private Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public Clan sacuvajClana(Clan clan) throws Exception {
        return (Clan) new SOSacuvajClana().execute(clan);
    }

    public Radnik sacuvajRadnika(Radnik radnik) throws Exception {
        return (Radnik) new SOSacuvajRadnika().execute(radnik);
    }

    public Object pronadjiRadnika(Radnik radnik) throws Exception {
        return (Radnik) new SOPronadjiRadnika().execute(radnik);
    }

    public Object pronadjiPrimerke() throws Exception {
        return (List<Primerak>) new SOPronadjiPrimerke().execute(new Primerak());
    }

    public Object sacuvajKnjigu(Knjiga knjiga) throws Exception {
        return new SOSacuvajKnjigu().execute(knjiga);
    }

    public Object vratiSveAutore() throws Exception {
        return (List<Autor>) new SOVratiSveAutore().execute(new Autor());
    }
}
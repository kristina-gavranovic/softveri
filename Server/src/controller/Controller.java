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
import domain.Zaduzenje;
import java.util.List;
import service.so.impl.SOBrisanjeKnjige;
import service.so.impl.SOPronadjiPrimerke;
import service.so.impl.SOPrijaviRadnika;
import service.so.impl.SOSacuvajClana;
import service.so.impl.SOSacuvajKnjigu;
import service.so.impl.SOSacuvajRadnika;
import service.so.impl.SOSacuvajZaduzenje;
import service.so.impl.SORazduziKnjigu;
import service.so.impl.SOVratiSveAutore;
import service.so.impl.SOVratiSveClanove;
import service.so.impl.SOVratiSveKnjige;
import service.so.impl.SOVratiZaduzenjaClana;

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

    public Object prijaviRadnika(Radnik radnik) throws Exception {
        return (Radnik) new SOPrijaviRadnika().execute(radnik);
    }

    public Object pronadjiPrimerke(String pretraga) throws Exception {
        return (List<Primerak>) new SOPronadjiPrimerke().execute(pretraga);
    }

    public Object sacuvajKnjigu(Knjiga knjiga) throws Exception {
        return new SOSacuvajKnjigu().execute(knjiga);
    }

    public Object vratiSveAutore() throws Exception {
        return (List<Autor>) new SOVratiSveAutore().execute(new Autor());
    }

    public Object vratiSveClanove() throws Exception{
        return (List<Clan>) new SOVratiSveClanove().execute(new Clan());

    }

    public Object sacuvajZaduzenje(Zaduzenje zaduzenje)throws Exception {
        return new SOSacuvajZaduzenje().execute(zaduzenje);
    }

    public Object vratiZaduzenja(int clanId)throws Exception {
        return (List<Zaduzenje>) new SOVratiZaduzenjaClana().execute(clanId);
    }

    public Object vratiKnjigu(Zaduzenje zaduzenje) throws Exception {
        return  new SORazduziKnjigu().execute(zaduzenje);
    }

    public Object vratiSveKnjige() throws Exception {
        return (List<Clan>) new SOVratiSveKnjige().execute(new Knjiga());
    }

    public Object brisanjeKnjige(Knjiga knjiga) throws Exception {
        return (boolean) new SOBrisanjeKnjige().execute(knjiga);
    }
}

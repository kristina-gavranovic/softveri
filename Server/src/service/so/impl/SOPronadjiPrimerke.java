/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.so.impl;

import domain.Autor;
import domain.IGeneralObject;
import domain.Knjiga;
import domain.Primerak;
import java.util.ArrayList;
import java.util.List;
import service.so.AbstractGenericOperation;

/**
 *
 * @author Kristina
 */
public class SOPronadjiPrimerke extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object entity) throws Exception {
        return;
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        List<Primerak> listKonacan = new ArrayList<>();
        List<Knjiga> listaKnjiga = convertToKnjiga(genericDao.find(new Knjiga()));

        for (Knjiga knjiga : listaKnjiga) {
            List<Primerak> listaPrimeraka = convertToPrimerak(genericDao.findBy(new Primerak(), "knjigaID", knjiga.getId().toString()));
            for (Primerak p : listaPrimeraka) {
                Primerak primerak = new Primerak(p.getRbr(), p.getIzdavac(), p.getStatus(), p.getGodinaIzdavanja(), knjiga.getId(), knjiga.getNaslov(), knjiga.getZanr(), knjiga.getOpis(), knjiga.getIsbn());

                listKonacan.add(primerak);
            }

        }
        return listKonacan;

    }

    private List<Primerak> convertToPrimerak(List<IGeneralObject> find) {
        List<Primerak> list = new ArrayList<>();
        for (IGeneralObject i : find) {
            list.add((Primerak) i);
        }
        return list;
    }

    private List<Knjiga> convertToKnjiga(List<IGeneralObject> find) {
        List<Knjiga> list = new ArrayList<>();
        for (IGeneralObject i : find) {
            list.add((Knjiga) i);
        }
        return list;
    }
}

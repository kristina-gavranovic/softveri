/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.so.impl;

import domain.Autor;
import domain.AutorKnjiga;
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
        
        List<Knjiga> listaKnjiga = convertToKnjiga(genericDao.find(new Knjiga()));

            //dodati metode koje setuju primerke i autore na knjigu 
            //promeniti tableModel za knjigu
        for (Knjiga knjiga : listaKnjiga) {
            System.out.println(knjiga+" je ucitana iz baze" +knjiga.getId());
            List<Primerak> listaPrimeraka = convertToPrimerak(genericDao.findBy(new Primerak(), "knjigaID", knjiga.getId().toString()));
            knjiga.setPrimerci(listaPrimeraka);
            
          
           List<AutorKnjiga> listaAutorKnjiga=convertToAutorKnjiga(genericDao.findBy(new AutorKnjiga(), "idKnjiga", knjiga.getId().toString()));
           
           List<Autor> listAutor=new ArrayList<>();
           for (AutorKnjiga ak : listaAutorKnjiga) {
                Autor a=(Autor) genericDao.findBy(new Autor(), "id", ak.getAutorID().toString()).get(0);
                listAutor.add(a);
            }
           knjiga.setAutori(listAutor);


        }
        return listaKnjiga;

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
     private List<AutorKnjiga> convertToAutorKnjiga(List<IGeneralObject> find) {
        List<AutorKnjiga> list = new ArrayList<>();
        for (IGeneralObject i : find) {
            list.add((AutorKnjiga) i);
        }
        return list;
    }
    
}

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
import service.so.AbstractGenericOperation;

/**
 *
 * @author Kristina
 */
public class SOSacuvajKnjigu  extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object entity) throws Exception {
        return;
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
         genericDao.save((Knjiga) entity);
         

         for (Primerak primerak : ((Knjiga)entity).getPrimerci()) {
             primerak.setId(((Knjiga)entity).getId());
             genericDao.save(primerak);

         }
            
        for (Autor autor : ((Knjiga)entity).getAutori()) {
            AutorKnjiga autorKnjiga=new AutorKnjiga();
            autorKnjiga.setAutor(autor);
            autorKnjiga.setKnjiga((Knjiga) entity);
            
            genericDao.save(autorKnjiga);

        
        }

        
    
        return true;
    }
    
    
    
}
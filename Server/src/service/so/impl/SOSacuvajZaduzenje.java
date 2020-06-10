/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.so.impl;

import domain.Primerak;
import domain.Zaduzenje;
import service.so.AbstractGenericOperation;

/**
 *
 * @author Kristina
 */
public class SOSacuvajZaduzenje extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object entity) throws Exception {
        return;
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        genericDao.update(((Zaduzenje) entity).getPrimerak());
        return genericDao.save((Zaduzenje) entity);
        
        
    }
    
}


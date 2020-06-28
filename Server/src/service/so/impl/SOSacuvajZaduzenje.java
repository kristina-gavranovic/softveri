
package service.so.impl;

import domain.Primerak;
import domain.Zaduzenje;
import service.so.AbstractGenericOperation;


public class SOSacuvajZaduzenje extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object entity) throws Exception {
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        genericDao.update(((Zaduzenje) entity).getPrimerak());
        return genericDao.save((Zaduzenje) entity);
        
        
    }
    
}


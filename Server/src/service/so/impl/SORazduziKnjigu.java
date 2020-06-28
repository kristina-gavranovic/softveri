
package service.so.impl;

import domain.Zaduzenje;
import service.so.AbstractGenericOperation;


public class SORazduziKnjigu extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object entity) throws Exception {
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        System.out.println(((Zaduzenje) entity).getPrimerak().getStatus()+"");
        genericDao.update(((Zaduzenje) entity).getPrimerak());
        
        return genericDao.update((Zaduzenje) entity);
    }

}

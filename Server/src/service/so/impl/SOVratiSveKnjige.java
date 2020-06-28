
package service.so.impl;

import domain.Knjiga;
import service.so.AbstractGenericOperation;


public class SOVratiSveKnjige extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object entity) throws Exception {
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        return genericDao.find((Knjiga) entity);
    }
    
}
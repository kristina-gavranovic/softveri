
package service.so.impl;

import domain.Autor;
import service.so.AbstractGenericOperation;


public class SOVratiSveAutore extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object entity) throws Exception {
       
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        return genericDao.find((Autor) entity);
    }
    
}
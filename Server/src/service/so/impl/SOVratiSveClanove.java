
package service.so.impl;

import domain.Clan;
import service.so.AbstractGenericOperation;


public class SOVratiSveClanove  extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object entity) throws Exception {
       
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        return genericDao.find((Clan) entity);
    }
    
}
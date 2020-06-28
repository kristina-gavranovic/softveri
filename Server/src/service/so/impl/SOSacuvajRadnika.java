
package service.so.impl;

import domain.Radnik;
import service.so.AbstractGenericOperation;
import service.validation.RadnikValidation;


public class SOSacuvajRadnika  extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object entity) throws Exception {
        RadnikValidation.validate((Radnik)entity);
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        return genericDao.save((Radnik) entity);
    }
    
}
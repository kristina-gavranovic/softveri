
package service.so.impl;

import domain.IGeneralObject;
import domain.Radnik;
import service.so.AbstractGenericOperation;
import service.validation.PrijavaRadnikaValidation;


public class SOPrijaviRadnika extends AbstractGenericOperation {
   

    @Override
    protected Object executeOperation(Object entity) throws Exception {

        Radnik expected = (Radnik) genericDao.get((Radnik) entity);
        System.out.println(expected.toString());
        PrijavaRadnikaValidation.validate(expected, (Radnik) entity);
        
        return expected;

    }

    @Override
    protected void preconditions(Object entity) throws Exception {
    }
}

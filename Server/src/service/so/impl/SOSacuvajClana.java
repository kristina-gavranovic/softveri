package service.so.impl;




import service.so.AbstractGenericOperation;
import domain.Clan;
import service.validation.ClanValidation;


public class SOSacuvajClana extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object entity) throws Exception {
            ClanValidation.validate((Clan) entity);
       
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        return genericDao.save((Clan) entity);
    }
    
}

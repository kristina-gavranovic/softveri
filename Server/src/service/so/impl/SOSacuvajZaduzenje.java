
package service.so.impl;

import domain.IGeneralObject;
import domain.Primerak;
import domain.Zaduzenje;
import java.util.ArrayList;
import java.util.List;
import service.so.AbstractGenericOperation;


public class SOSacuvajZaduzenje extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object entity) throws Exception {
                List<IGeneralObject> list= genericDao.find(new Zaduzenje());
                
                int brojZaduzenja=0;
                for (IGeneralObject i : list) {
                    
                    //System.out.println(((Zaduzenje)i).getClan().getId()+"trenutni");
                   // System.out.println(((Zaduzenje)entity).getClan().getId()+" zadati");
                    
                    Integer i1=((Zaduzenje)entity).getClan().getId();
                    Integer i2=((Zaduzenje)i).getClan().getId();
                    
                    if(i1.intValue()==i2.intValue()){
                    
                    brojZaduzenja++;
                    }
                    
                    
        }
               if(brojZaduzenja>=3) throw new Exception("Clan ima vec 3 zaduzeja!");
                

    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        
        
        genericDao.update(((Zaduzenje) entity).getPrimerak());
        return genericDao.save((Zaduzenje) entity);
        
        
    }

   
    
}


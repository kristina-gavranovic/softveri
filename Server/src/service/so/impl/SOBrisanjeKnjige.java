/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.so.impl;

import domain.IGeneralObject;
import domain.Knjiga;
import service.so.AbstractGenericOperation;

/**
 *
 * @author Kristina
 */
public class SOBrisanjeKnjige  extends  AbstractGenericOperation{

    @Override
    protected void preconditions(Object entity) throws Exception {
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
            return genericDao.delete((Knjiga) entity);

    }
    
}

package service.so.impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import service.so.AbstractGenericOperation;
import domain.Clan;

/**
 *
 * 
 */
public class SOSacuvajClana extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object entity) throws Exception {
        return;
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        return genericDao.save((Clan) entity);
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.so.impl;

import domain.Zaduzenje;
import service.so.AbstractGenericOperation;

/**
 *
 * @author Kristina
 */
public class SOVratiKnjigu extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object entity) throws Exception {
        return;
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        System.out.println(((Zaduzenje) entity).getPrimerak().getStatus()+"");
        genericDao.update(((Zaduzenje) entity).getPrimerak());
        
        return genericDao.update((Zaduzenje) entity);

    }

}

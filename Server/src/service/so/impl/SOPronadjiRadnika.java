/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.so.impl;

import domain.IGeneralObject;
import domain.Radnik;
import service.so.AbstractGenericOperation;
import service.validation.RadnikValidation;

/**
 *
 * @author Kristina
 */
public class SOPronadjiRadnika extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object entity) throws Exception {
        return;
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {

        Radnik expected = (Radnik) genericDao.get((IGeneralObject) entity);
        RadnikValidation.validate(expected, (Radnik) entity);
        return expected;

    }
}

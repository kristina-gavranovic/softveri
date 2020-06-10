/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.so.impl;

import domain.Clan;
import domain.IGeneralObject;
import domain.Primerak;
import domain.Zaduzenje;
import java.util.ArrayList;
import java.util.List;
import service.so.AbstractGenericOperation;

/**
 *
 * @author Kristina
 */
public class SOVratiZaduzenja extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object entity) throws Exception {
        return;
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {

        List<Zaduzenje> zaduzenja = convertToZaduzenje(genericDao.find  ((Zaduzenje) entity));
        for (Zaduzenje z : zaduzenja) {
            mapClan2(z);
            System.out.println(z.getClan().getId()+z.getClan().getPrezime());
            mapPrimerak(z);
        }
        return zaduzenja;
    }

    private void mapClan(Zaduzenje z) throws Exception {
       List<Clan> list = convertToClan(genericDao.findBy(new Clan(), "id", z.getClan().getId() + ""));
       // Clan clan=(Clan) genericDao.get(z.getClan());
        z.setClan((Clan)list.get(0));
    }
        private void mapClan2(Zaduzenje z) throws Exception {
              z.setClan((Clan) genericDao.get(z.getClan()));

    }
    
    

    private void mapPrimerak(Zaduzenje z) throws Exception {
        List<IGeneralObject> list = genericDao.findBy(new Primerak(), "rbr", z.getPrimerak().getRbr() + "");
        z.setPrimerak((Primerak) list.get(0));
    }

    private List<Zaduzenje> convertToZaduzenje(List<IGeneralObject> find) {
        List<Zaduzenje> list = new ArrayList<>();
        for (IGeneralObject i : find) {
            list.add((Zaduzenje) i);
        }
        return list;
    }
   private List<Clan> convertToClan(List<IGeneralObject> find) {
        List<Clan> list = new ArrayList<>();
        for (IGeneralObject i : find) {
            list.add((Clan) i);
        }
        return list;
    }

}

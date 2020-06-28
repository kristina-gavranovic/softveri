
package service.so.impl;

import domain.Clan;
import domain.Primerak;
import domain.Zaduzenje;
import java.util.ArrayList;
import java.util.List;
import service.so.AbstractGenericOperation;
import service.util.IGeneralObjectConverter;


public class SOVratiZaduzenjaClana extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object entity) throws Exception {
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        List<Zaduzenje> zaduzenja = IGeneralObjectConverter.convertToZaduzenje(genericDao.find(new Zaduzenje()));
        mapObjects(zaduzenja);
        if ((int)entity != -1) {
                List<Zaduzenje> searchResults = new ArrayList<>();

                for (Zaduzenje zaduzenje : zaduzenja) {
                    if (zaduzenje.getClan().getId() == (int)entity) {
                        searchResults.add(zaduzenje);
                    }
                }
                return (ArrayList<Zaduzenje>) searchResults;
        }   throw new Exception("Clan nema zaduzenja!");
 }

    private void mapObjects(List<Zaduzenje> zaduzenja) throws Exception {
        for (Zaduzenje z : zaduzenja) {
            z.setClan((Clan) genericDao.get(z.getClan()));
            z.setPrimerak((Primerak) genericDao.get(z.getPrimerak()));
        }
    }
}

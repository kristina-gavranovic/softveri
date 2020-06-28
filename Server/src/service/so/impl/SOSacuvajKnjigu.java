
package service.so.impl;

import domain.Autor;
import domain.AutorKnjiga;
import domain.IGeneralObject;
import domain.Knjiga;
import domain.Primerak;
import service.so.AbstractGenericOperation;
import service.validation.KnjigaValidation;


public class SOSacuvajKnjigu extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object entity) throws Exception {
        KnjigaValidation.validateKnjiga((Knjiga) entity);
        for (Primerak primerak : ((Knjiga) entity).getPrimerci()) {
            KnjigaValidation.validatePrimerak(primerak);
            
        }
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {
        genericDao.save((Knjiga) entity);

        for (Primerak primerak : ((Knjiga) entity).getPrimerci()) {
            primerak.setKnjigaId(((Knjiga) entity).getId());
            genericDao.save(primerak);
        }

        for (Autor autor : ((Knjiga) entity).getAutori()) {
            AutorKnjiga autorKnjiga = new AutorKnjiga();
            autorKnjiga.setAutorID(autor.getId());
            autorKnjiga.setKnjigaID(((Knjiga) entity).getId());

            genericDao.save(autorKnjiga);
        }

        return true;
    }
}

package service.so.impl;

import domain.Autor;
import domain.AutorKnjiga;
import domain.Knjiga;
import domain.Primerak;
import java.util.ArrayList;
import java.util.List;
import service.so.AbstractGenericOperation;
import service.util.IGeneralObjectConverter;

public class SOPronadjiPrimerke extends AbstractGenericOperation {

    @Override
    protected void preconditions(Object entity) throws Exception {
    }

    @Override
    protected Object executeOperation(Object entity) throws Exception {

        List<Knjiga> listaKnjiga = IGeneralObjectConverter.convertToKnjiga(genericDao.find(new Knjiga()));
        ArrayList<Knjiga> listZadovoljavaUslov = new ArrayList<>();

        
        mapObjects(listaKnjiga);

        for (Knjiga knjiga : listaKnjiga) {
            if (knjiga.getNaslov().toLowerCase().contains(((String) entity).toLowerCase())) {
                listZadovoljavaUslov.add(knjiga);
            } else if (knjiga.autoriToString((ArrayList<Autor>) knjiga.getAutori()).toLowerCase().contains(((String) entity).toLowerCase())) {
                listZadovoljavaUslov.add(knjiga);
            }

        }
        if (listZadovoljavaUslov.isEmpty()) {
            throw new Exception("Sistem ne moze da pronadje knjige!");
        }

        return listZadovoljavaUslov;
    }

    private void mapObjects(List<Knjiga> listaKnjiga) throws Exception {
        for (Knjiga knjiga : listaKnjiga) {
            List<Primerak> listaPrimeraka = IGeneralObjectConverter.convertToPrimerak(genericDao.findBy(new Primerak(), "knjigaID", knjiga.getId().toString()));
            knjiga.setPrimerci(listaPrimeraka);

            List<AutorKnjiga> listaAutorKnjiga = IGeneralObjectConverter.convertToAutorKnjiga(genericDao.findBy(new AutorKnjiga(), "idKnjiga", knjiga.getId().toString()));

            List<Autor> listAutor = new ArrayList<>();
            for (AutorKnjiga ak : listaAutorKnjiga) {

                Autor a1 = (Autor) genericDao.get(new Autor(ak.getAutorID()));
                listAutor.add(a1);
            }
            knjiga.setAutori(listAutor);
        }
    }
}

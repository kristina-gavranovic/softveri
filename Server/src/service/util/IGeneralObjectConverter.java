
package service.util;

import domain.AutorKnjiga;
import domain.IGeneralObject;
import domain.Knjiga;
import domain.Primerak;
import domain.Zaduzenje;
import java.util.ArrayList;
import java.util.List;


public class IGeneralObjectConverter {

    public static List<Zaduzenje> convertToZaduzenje(List<IGeneralObject> find) {
        List<Zaduzenje> list = new ArrayList<>();
        for (IGeneralObject i : find) {
            list.add((Zaduzenje) i);
        }
        return list;
    }

    public static List<Primerak> convertToPrimerak(List<IGeneralObject> find) {
        List<Primerak> list = new ArrayList<>();
        for (IGeneralObject i : find) {
            list.add((Primerak) i);
        }
        return list;
    }

    public static List<Knjiga> convertToKnjiga(List<IGeneralObject> find) {
        List<Knjiga> list = new ArrayList<>();
        for (IGeneralObject i : find) {
            list.add((Knjiga) i);
        }
        return list;
    }

    public static List<AutorKnjiga> convertToAutorKnjiga(List<IGeneralObject> find) {
        List<AutorKnjiga> list = new ArrayList<>();
        for (IGeneralObject i : find) {
            list.add((AutorKnjiga) i);
        }
        return list;
    }
}

package service.validation;

import domain.Knjiga;
import domain.Primerak;
import util.AbstractValidation;

public class KnjigaValidation extends AbstractValidation {

    public static void validateKnjiga(Knjiga knjiga) throws Exception {
        notNull("Knjiga je null", knjiga);
        notEmpty("Unesite naslov", knjiga.getNaslov());
        notEmpty("Unesite ISBN", knjiga.getIsbn());
        isGoodLength("ISBN treba imati 13 cifara", knjiga.getIsbn(), 13);
        isNumeric("ISBN nije u dobrom formatu", knjiga.getIsbn());
    }

    public static void validatePrimerak(Primerak primerak) throws Exception {
        notNull("Primerak je null", primerak);
        notEmpty("Unesite izdavaca", primerak.getIzdavac());
        notNull("Unesite godinu izdavanja", primerak.getGodinaIzdavanja());
    }
}

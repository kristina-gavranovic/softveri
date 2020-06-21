
package ui.form_validation;

import domain.Knjiga;
import domain.Primerak;
import util.AbstractValidation;


public class KnjigaFormValidation extends AbstractValidation {
    public static void validateKnjiga(Knjiga knjiga) throws Exception {
        notNull("Knjiga je null", knjiga);
        notEmpty("Unesite naslov", knjiga.getNaslov());
        notEmpty("Unesite ISBN", knjiga.getIsbn());
    }
     public static void validatePrimerak(Primerak primerak) throws Exception {
        notNull("Primerak je null", primerak);
        notEmpty("Unesite izdavaca", primerak.getIzdavac());
        notNull("Unesite godinu izdavanja", primerak.getGodinaIzdavanja());
    }
}
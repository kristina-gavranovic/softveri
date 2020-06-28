
package service.validation;

import domain.Radnik;
import util.AbstractValidation;


public class PrijavaRadnikaValidation extends AbstractValidation {

    public static void validate(Radnik expected, Radnik actual) throws Exception {
        notNull("Korisnik ne postoji!", expected);
        notEquals("Pogresan password!", expected.getPassword().trim(), actual.getPassword().trim());
        isActive("Radnik nije aktivan!", expected);
        
    }

}

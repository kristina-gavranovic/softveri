
package ui.form_validation;

import domain.Radnik;
import util.AbstractValidation;


public class RadnikFormValidation  extends AbstractValidation {

    public static void validate(Radnik newRadnik) throws Exception {
        notNull("Radnik ne moze biti null", newRadnik);
        notEmpty("Unesite ime", newRadnik.getIme());
        notEmpty("Unesite prezime", newRadnik.getPrezime());
        notEmpty("Unesite username", newRadnik.getUsername());
        notEmpty("Unesite password", newRadnik.getPassword());
    }
    
}

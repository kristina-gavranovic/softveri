package ui.form_validation;



import domain.Radnik;
import util.AbstractValidation;


public class LoginFormValidation extends AbstractValidation {
    public static void validate(Radnik radnik) throws Exception {
        notNull("Radnik je null", radnik);
        notEmpty("Unesite username", radnik.getUsername());
        notEmpty("Unesite password", radnik.getPassword());
    }
}

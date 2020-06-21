package ui.form_validation;



import domain.Clan;
import util.AbstractValidation;


public class ClanFormValidation extends AbstractValidation {

    public static void validate(Clan newClan) throws Exception {
        notNull("Clan ne sme biti null", newClan);
        notEmpty("Unesite ime", newClan.getIme());
        notEmpty("Unesite prezime", newClan.getPrezime());
        notEmpty("Unesite JMBG", newClan.getJmbg());
        notEmpty("Unesite telefon", newClan.getTelefon());
    }
    
}

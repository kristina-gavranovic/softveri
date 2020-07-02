package ui.form_validation;

import domain.Clan;
import util.AbstractValidation;

public class ClanFormValidation extends AbstractValidation {

    public static void validate(Clan clan) throws Exception {
        notNull("Clan ne sme biti null", clan);
        notEmpty("Unesite ime", clan.getIme());
        notEmpty("Unesite prezime", clan.getPrezime());
        notEmpty("Unesite JMBG", clan.getJmbg());
        isGoodLength("JMBG treba imati 13 cifara!", clan.getJmbg(), 13);
        isNumeric("JMBG nije u dobrom formatu!", clan.getJmbg());
        notEmpty("Unesite telefon", clan.getTelefon());
        isNumeric("Telefon nije u dobrom formatu!", clan.getTelefon());
    }

}

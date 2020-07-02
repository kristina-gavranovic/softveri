package service.validation;

import util.AbstractValidation;
import domain.Clan;

public class ClanValidation extends AbstractValidation {

    public static void validate(Clan clan) throws Exception {
        notNull("Clan ne sme biti null", clan);
        notEmpty("Unesite ime", clan.getIme());
        notEmpty("Unesite prezime", clan.getPrezime());
        notEmpty("Unesite JMBG", clan.getJmbg());
        notEmpty("Unesite telefon", clan.getTelefon());
        isGoodLength("JMBG treba imati 13 cifara!", clan.getJmbg().trim(), 13);
        isNumeric("JMBG nije u dobrom formatu!", clan.getJmbg());
        isNumeric("Telefon nije u dobrom formatu!", clan.getTelefon());

    }
}

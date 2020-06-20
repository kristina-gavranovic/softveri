package ui.form_validation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import domain.Clan;
import util.AbstractValidation;

/**
 *
 * @author Dudat
 */
public class ClanFormValidation extends AbstractValidation {

    public static void validate(Clan newClan) throws Exception {
        notNull("Clan cant be null", newClan);
        notEmpty("Unesite ime", newClan.getIme());
        notEmpty("Unesite prezime", newClan.getPrezime());
        notEmpty("Unesite JMBG", newClan.getJmbg());
        notEmpty("Unesite telefon", newClan.getTelefon());
    }
    
}

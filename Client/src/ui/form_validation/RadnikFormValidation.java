/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.form_validation;

import domain.Radnik;
import util.AbstractValidation;

/**
 *
 * @author Kristina
 */
public class RadnikFormValidation  extends AbstractValidation {

    public static void validate(Radnik newRadnik) throws Exception {
        notNull("Radnik cant be null", newRadnik);
        notEmpty("Unesite ime", newRadnik.getIme());
        notEmpty("Unesite prezime", newRadnik.getPrezime());
        notEmpty("Unesite username", newRadnik.getUsername());
        notEmpty("Unesite password", newRadnik.getPassword());
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.validation;

import domain.Radnik;
import util.AbstractValidation;

/**
 *
 * @author Kristina
 */
public class RadnikValidation extends AbstractValidation {

    public static void validate(Radnik expected, Radnik actual) throws Exception {
        notNull("Korisnik ne postoji", expected);
        notEquals("Pogresan password", expected.getPassword().trim(), actual.getPassword().trim());
    }

}

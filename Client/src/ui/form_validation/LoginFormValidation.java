package ui.form_validation;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import domain.Radnik;
import util.AbstractValidation;

/**
 *
 * @author Dudat
 */
public class LoginFormValidation extends AbstractValidation {
    public static void validate(Radnik employee) throws Exception {
        notNull("Radnik is null", employee);
        notEmpty("Unesite username", employee.getUsername());
        notEmpty("Unesite password", employee.getPassword());
    }
}

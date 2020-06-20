/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui.form_validation;

import domain.Knjiga;
import domain.Primerak;
import util.AbstractValidation;

/**
 *
 * @author Kristina
 */
public class KnjigaFormValidation extends AbstractValidation {
    public static void validateKnjiga(Knjiga knjiga) throws Exception {
        notNull("Knjiga is null", knjiga);
        notEmpty("Unesite naslov", knjiga.getNaslov());
        notEmpty("Unesite ISBN", knjiga.getIsbn());
    }
     public static void validatePrimerak(Primerak primerak) throws Exception {
        notNull("Knjiga is null", primerak);
        notEmpty("Unesite izdavaca", primerak.getIzdavac());
        notNull("Unesite godinu izdavanja", primerak.getGodinaIzdavanja());
    }
}

package service.validation;


import domain.Radnik;
import util.AbstractValidation;

public class RadnikValidation extends  AbstractValidation{
  public static void validate(Radnik  radnik) throws Exception {
        notNull("Radnik ne sme biti null", radnik);
        notEmpty("Unesite ime", radnik.getIme());
        notEmpty("Unesite prezime", radnik.getPrezime());
        notEmpty("Unesite username", radnik.getUsername());
        notEmpty("Unesite password ", radnik.getPassword());
        notNull("Status radnika ne sme biti null", radnik.getStatus());
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.Serializable;

/**
 *
 * @author student1
 */
public interface Operation extends Serializable {

    public static final int OPERATION_LOGIN = 1;
    public static final int OPERATION_SVI_AUTORI = 2;
    public static final int OPERATION_SACUVAJ_RADNIKA = 3;
    public static final int OPERATION_SACUVAJ_KNJIGU = 4;
    public static final int OPERATION_SACUVAJ_CLANA = 5;
    public static final int OPERATION_PRETRAGA_KNJIGA = 6;
    public static final int OPERATION_SVI_CLANOVI = 7;
    public static final int OPERATION_SACUVAJ_ZADUZENJE = 8;
    public static final int OPERATION_SVA_ZADUZENJA = 9;
    public static final int OPERATION_VRATI_KNJIGU= 10;
    public static final int OPERATION_SVE_KNJIGE= 11;

}

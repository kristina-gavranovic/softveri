/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domain.Primerak;
import java.util.ArrayList;

/**
 *
 * @author Kristina
 */
public interface StoragePrimerak {

    public ArrayList<Primerak> pronadjiPrimerke(String pretraga) throws  Exception;
    
}

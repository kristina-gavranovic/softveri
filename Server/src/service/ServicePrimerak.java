/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Primerak;
import java.util.ArrayList;
import storage.StoragePrimerak;

/**
 *
 * @author Kristina
 */
public interface ServicePrimerak {
    
 
    public ArrayList<Primerak> pronadjiPrimerke(String pretraga);
    
}

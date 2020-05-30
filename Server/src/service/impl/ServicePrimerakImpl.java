/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.Primerak;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import service.ServicePrimerak;
import storage.StoragePrimerak;
import storage.impl.database.StorageDatabasePrimerak;

/**
 *
 * @author Kristina
 */
public class ServicePrimerakImpl implements  ServicePrimerak {
    
    private  final StoragePrimerak storagePrimerak;

    public ServicePrimerakImpl() {
        this.storagePrimerak = new StorageDatabasePrimerak();
                
    }
    
    
 /////OVDe je dodat try catch pogledaj posle sto se bunio kompajler ?????
    @Override
    public ArrayList<Primerak> pronadjiPrimerke(String pretraga) {
        
        
        try {
            return  storagePrimerak.pronadjiPrimerke(pretraga);
        } catch (Exception ex) {
            Logger.getLogger(ServicePrimerakImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
       
    }
    
}

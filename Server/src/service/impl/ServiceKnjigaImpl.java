/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.Knjiga;
import service.ServiceKnjiga;
import storage.StorageKnjiga;
import storage.impl.database.StorageDatabaseKnjiga;

/**
 *
 * @author Kristina
 */
public class ServiceKnjigaImpl implements  ServiceKnjiga{
    
    private final  StorageKnjiga storageKnjiga;

    public ServiceKnjigaImpl() {
        this.storageKnjiga = new StorageDatabaseKnjiga();
    }
    
    

    @Override
    public Knjiga sacuvaj(Knjiga knjiga) throws Exception {
          
            return storageKnjiga.sacuvaj(knjiga);
     


    }
    
}

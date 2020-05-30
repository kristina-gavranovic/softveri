/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.Radnik;
import service.ServiceRadnik;
import storage.StorageRadnik;
import storage.impl.database.StorageDatabaseRadnik;

/**
 *
 * @author student1
 */
public class ServiceRadnikImpl implements ServiceRadnik{
    
    private final StorageRadnik storageRadnik;

    public ServiceRadnikImpl() {
        storageRadnik =new StorageDatabaseRadnik();
    }
    
    
    
    @Override
    public Radnik pronadjiRadnika(String username, String password) throws Exception {
        return storageRadnik.pronadjiRadnika(username, password);
    }

    @Override
    public Radnik sacuvaj(Radnik radnik) throws Exception {
     try {
            return storageRadnik.sacuvaj(radnik);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new Exception("Sistem ne moze da sacuva podatke o novom radniku.");
        }
    }
    
}

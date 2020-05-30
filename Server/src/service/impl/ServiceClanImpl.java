/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.Clan;
import storage.StorageClan;
import storage.impl.database.StorageDatabaseClan;

/**
 *
 * @author Kristina
 */
public class ServiceClanImpl implements  service.ServiceClan{
    private  final StorageClan storageClan;

    public ServiceClanImpl() {
        this.storageClan = new StorageDatabaseClan();
        
    }

  

    @Override
    public Clan sacuvaj(Clan clan) throws Exception {
         try {
            return storageClan.sacuvaj(clan);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            throw new Exception("Sistem ne moze da sacuva podatke o novom clanu.");
        }

    }
    
    
}

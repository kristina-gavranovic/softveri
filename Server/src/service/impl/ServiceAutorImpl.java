/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.impl;

import domain.Autor;
import java.util.List;
import storage.impl.database.StorageDatabaseAutor;
import service.ServiceAutor;
import storage.StorageAutor;

/**
 *
 * @author student1
 */
public class ServiceAutorImpl implements ServiceAutor{
    private final StorageAutor storageAutor;

    public ServiceAutorImpl() {
        storageAutor = new StorageDatabaseAutor();
    }

    @Override
    public List<Autor> vratiSve() {
        return storageAutor.vratiSve();
    }
    
}

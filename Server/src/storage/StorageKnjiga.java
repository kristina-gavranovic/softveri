/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domain.Knjiga;

/**
 *
 * @author Kristina
 */
public interface StorageKnjiga {

  

    public Knjiga sacuvaj(Knjiga knjiga) throws Exception;
    
}

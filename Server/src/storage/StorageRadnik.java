/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage;

import domain.Radnik;

/**
 *
 * @author student1
 */
public interface StorageRadnik {
    
    Radnik pronadjiRadnika(String username,String password) throws Exception;

    public Radnik sacuvaj(Radnik radnik) throws Exception;
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import domain.Clan;
import domain.Knjiga;
import domain.Radnik;

/**
 *
 * @author student1
 */
public interface ServiceRadnik {
    
    Radnik pronadjiRadnika(String username,String password) throws Exception;

    public Radnik sacuvaj(Radnik radnik)throws Exception;

    

   
}

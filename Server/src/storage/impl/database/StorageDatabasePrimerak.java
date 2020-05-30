/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.impl.database;

import database.connection.ConnectionFactory;
import domain.Primerak;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import storage.StoragePrimerak;

/**
 *
 * @author Kristina
 */
public class StorageDatabasePrimerak implements StoragePrimerak {

    @Override
    public ArrayList<Primerak> pronadjiPrimerke(String pretraga) throws  Exception{
        ArrayList<Primerak> primerci = new ArrayList<>();
        
        Connection connection = ConnectionFactory.getInstance().getConnection();
        String query = "SELECT * FROM primerak JOIN knjiga ON knjiga.id=primerak.knjigaid WHERE naslov LIKE '%"+pretraga+"%' " ;
        Statement preparedStatement = connection.createStatement();
     
        ResultSet rs = preparedStatement.executeQuery(query);
        while (rs.next()) {
            Primerak primerak=new Primerak();
            primerak.setId(rs.getInt("id"));
            primerak.setIsbn(rs.getString("isbn"));
            primerak.setIzdavac(rs.getString("izdavac"));
            primerak.setNaslov(rs.getString("naslov"));
            primerak.setStatus(rs.getString("status"));
            primerak.setZanr(rs.getString("zanr"));
            primerak.setOpis(rs.getString("opis"));
            primerak.setGodinaIzdavanja(rs.getInt("godinaizdavanja"));
            
            primerci.add(primerak);
           
           
        } 
         rs.close();
        preparedStatement.close();
            return primerci;

        

    }

}

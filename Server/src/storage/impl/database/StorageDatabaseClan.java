/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.impl.database;

import database.connection.ConnectionFactory;
import domain.Clan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import storage.StorageClan;

/**
 *
 * @author Kristina
 */
public class StorageDatabaseClan implements  StorageClan{

    @Override
    public Clan sacuvaj(Clan clan) throws Exception{
         Connection connection = ConnectionFactory.getInstance().getConnection();
        String query = "INSERT INTO clan (ime,prezime,jmbg,telefon) VALUES(?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, clan.getIme());
        preparedStatement.setString(2, clan.getPrezime());
        preparedStatement.setString(3, clan.getJmbg());
        preparedStatement.setString(4, clan.getTelefon());
        preparedStatement.executeUpdate();

        // uzmi generisan id:
        ResultSet rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1); 
            clan.setId(id);
        } else {
            throw new Exception("Greska! Problem sa generisanjem id-ja clana.");
        }
        connection.commit();
        preparedStatement.close();
        return clan;

    }
    
}

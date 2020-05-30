/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.impl.database;

import database.connection.ConnectionFactory;
import domain.Radnik;
import domain.StatusRadnika;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import storage.StorageRadnik;

/**
 *
 * @author student1
 */
public class StorageDatabaseRadnik implements StorageRadnik {

    @Override
    public Radnik pronadjiRadnika(String username, String password) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        String query = "Select * from radnik where username=? and password=?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            Radnik user = new Radnik();
            user.setIme(rs.getString("ime"));
            user.setPrezime(rs.getString("prezime"));
            user.setStatus(StatusRadnika.valueOf(rs.getString("status")));
            user.setUsername(rs.getString("username"));
            user.setId(rs.getInt("id"));
            rs.close();
            preparedStatement.close();
            return user;
        }

        rs.close();
        preparedStatement.close();
        throw new Exception("Sistem ne moze da pronadje bibliotekara po zadatim vrednosima.");

    }

    @Override
    public Radnik sacuvaj(Radnik radnik) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        String query = "INSERT INTO radnik (ime,prezime,username,password,status) VALUES(?,?,?,?,?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, radnik.getIme());
        preparedStatement.setString(2, radnik.getPrezime());
        preparedStatement.setString(3, radnik.getUsername());
        preparedStatement.setString(4, radnik.getPassword());
        preparedStatement.setString(5, String.valueOf(radnik.getStatus()));
        preparedStatement.executeUpdate();

        // uzmi generisan id:
        ResultSet rs = preparedStatement.getGeneratedKeys();
        if (rs.next()) {
            int id = rs.getInt(1); 
            radnik.setId(id);
        } else {
            throw new Exception("Greska! Problem sa generisanjem id-ja radnika.");
        }
        connection.commit();
        preparedStatement.close();
        return radnik;
    }

}

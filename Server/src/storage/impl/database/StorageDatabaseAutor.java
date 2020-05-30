/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.impl.database;

import database.connection.ConnectionFactory;
import domain.Autor;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import storage.StorageAutor;

/**
 *
 * @author student1
 */
public class StorageDatabaseAutor implements StorageAutor {

   

    @Override
    public List<Autor> vratiSve() {


      List<Autor> autori = new ArrayList<>();
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();
            String query = "SELECT * FROM autor";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            
            while (rs.next()) {
                int id = rs.getInt("id");
                String ime = rs.getString("ime");
                String prezime=rs.getString("prezime");
                String zemljaPorekla=rs.getString("zemljaPorekla");
                
                Autor autor=new Autor(id, ime, prezime, zemljaPorekla);
                autori.add(autor);
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
           try {
               throw new SQLException(ex.getMessage());
           } catch (SQLException ex1) {
               Logger.getLogger(StorageDatabaseAutor.class.getName()).log(Level.SEVERE, null, ex1);
           }
        }

        return autori;
    }

    }



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package storage.impl.database;

import database.connection.ConnectionFactory;
import domain.Autor;
import domain.Knjiga;
import domain.Primerak;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Kristina
 */
public class StorageDatabaseKnjiga implements storage.StorageKnjiga {

    @Override
    public Knjiga sacuvaj(Knjiga knjiga) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();

        String upit = "INSERT INTO knjiga (naslov,zanr,isbn,opis) VALUES (?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        preparedStatement.setString(1, knjiga.getNaslov());
        preparedStatement.setString(2, knjiga.getZanr());
        preparedStatement.setString(3, knjiga.getIsbn());
        preparedStatement.setString(4, knjiga.getOpis());
        
        //mora se cuvati lista autora !!
        preparedStatement.executeUpdate();
        ResultSet rs = preparedStatement.getGeneratedKeys();

        if (rs.next()) {
            int knjigaID = rs.getInt(1);
            knjiga.setId(knjigaID);
            
            //dodavanje autaora u tabelu AutorKnjiga:
            upit="INSERT INTO AutorKnjiga (idknjiga,idautor) VALUES (?,?)";
            preparedStatement=connection.prepareStatement(upit);
            for (Autor autor : knjiga.getAutori()) {
                preparedStatement.setInt(1, knjiga.getId());
                preparedStatement.setInt(2, autor.getId());
                preparedStatement.executeUpdate();
            }
            
            
            //dodavanje primeraka:
            upit = "INSERT INTO primerak (izdavac,godinaIzdavanja,status,knjigaID) VALUES (?,?,?,?)";
            preparedStatement = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
            for (Primerak primerak : knjiga.getPrimerci()) {
                preparedStatement.setString(1, primerak.getIzdavac());
                preparedStatement.setInt(2, primerak.getGodinaIzdavanja());
                preparedStatement.setString(3, primerak.getStatus());
                preparedStatement.setInt(4, knjiga.getId());
                preparedStatement.executeUpdate();
                rs = preparedStatement.getGeneratedKeys();
                if (rs.next()) {
                    int rbr = rs.getInt(1);
                    primerak.setRbr(rbr);
                }

            }
            connection.commit(); 

        } else {
            connection.rollback();
            throw new Exception("Sistem ne moze da sacuva podatke o novoj knjizi");
        }

        return knjiga;
    }

}

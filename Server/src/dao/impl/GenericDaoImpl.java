/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import dao.GenericDao;
import domain.IGeneralObject;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import database.connection.ConnectionFactory;

/**
 *
 * @author Dudat
 */
public class GenericDaoImpl implements GenericDao {
    @Override
    public IGeneralObject update(IGeneralObject generalObject) throws Exception {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();

            String query = new StringBuilder()
                    .append("UPDATE biblioteka.")
                    .append(generalObject.getTableName())
                    .append(" SET ")
                    .append(generalObject.getUpdateValues())
                    .append(" WHERE ")
                    .append(generalObject.getObjectCase())
                    .toString();

            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

            statement.close();
            return generalObject;
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    @Override
    public IGeneralObject save(IGeneralObject generalObject) throws Exception {
        try {
            Connection connection = ConnectionFactory.getInstance().getConnection();

            String query = new StringBuilder()
                    .append("INSERT INTO biblioteka.")
                    .append(generalObject.getTableName())
                    .append(" (")
                    .append(generalObject.getColumnNamesForInsert())
                    .append(")")
                    .append(" VALUES (")
                    .append(generalObject.getInsertValues())
                    .append(")")
                    .toString();
            
            System.out.println(query);
            
                    
            Statement statement = connection.createStatement();
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            
            ResultSet rs = statement.getGeneratedKeys();
            
            if (rs.next()) generalObject.setId(rs.getInt(1));
            
            statement.close();
            return generalObject;
        } catch (SQLException ex) {
            throw ex;
        } catch (Exception ex) {
            throw ex;
        }
    }

    @Override
    public List<IGeneralObject> find(IGeneralObject ide) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        
        String query = "SELECT * FROM biblioteka." + ide.getTableName();
        Statement s = connection.createStatement();
        
        return ide.getList(s.executeQuery(query));
    }
    
    @Override
    public boolean delete(IGeneralObject object) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();
        
        String query = new StringBuilder()
                .append("DELETE FROM biblioteka.")
                .append(object.getTableName())
                .append(" WHERE ")
                .append(object.getObjectCase())
                .toString();
        
        if(connection.createStatement().executeUpdate(query) > 0)
            return true;
        throw new Exception(object.getTableName() + " cant be deleted");
    }
    
    @Override
    public List<IGeneralObject> findBy(IGeneralObject object, String field, String value) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();

        String query = new StringBuilder()
                .append("SELECT * FROM biblioteka.")
                .append(object.getTableName())
                .append(" WHERE ").append(field).append(" = '").append(value).append("'")
                .toString();
        
        Statement s = connection.createStatement();

        return object.getList(s.executeQuery(query));
    }

    @Override
    public IGeneralObject get(IGeneralObject object) throws Exception {
        Connection connection = ConnectionFactory.getInstance().getConnection();

        String query = new StringBuilder()
                .append("SELECT * FROM biblioteka.")
                .append(object.getTableName())
                .append(" WHERE ")
                .append(object.getObjectCase())
                .toString();
        
        System.out.println(query);

        Statement s = connection.createStatement();

        return object.getObject(s.executeQuery(query));
    }
}

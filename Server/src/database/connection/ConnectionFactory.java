
package database.connection;

import util.PropertyReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private Connection connection;
    public static ConnectionFactory instance;

    private ConnectionFactory() throws SQLException {

        try {

            String url = PropertyReader.getInstance().getProperty("db.url");
            String username = PropertyReader.getInstance().getProperty("db.user");
            String password = PropertyReader.getInstance().getProperty("db.pass");
            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(Boolean.valueOf(PropertyReader.getInstance().getProperty("db.autocommit")));

            connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
        } catch (SQLException ex) {
            throw new SQLException("Konekcija nije kreirana!");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public static ConnectionFactory getInstance() throws SQLException {
        if (instance == null) {
            instance = new ConnectionFactory();
        }
        return instance;
    }
}

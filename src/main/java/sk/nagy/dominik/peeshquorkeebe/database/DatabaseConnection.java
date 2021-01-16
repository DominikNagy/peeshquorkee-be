package sk.nagy.dominik.peeshquorkeebe.database;

// localhost postgres
// userName: peeshko
// password: str0ng_P4ss
// database: peeshquorkee

import java.sql.*;
import java.util.Properties;

public class DatabaseConnection {

    private Connection connection;

    public DatabaseConnection() {
        Properties properties = new Properties();
        properties.setProperty("user", "peeshko");
        properties.setProperty("password", "str0ng_P4ss");
        try {
            String DATABASE_URL = "jdbc:postgresql://192.168.100.24/peeshquorkee";
            this.connection = DriverManager.getConnection(DATABASE_URL, properties);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

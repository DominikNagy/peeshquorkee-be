package sk.nagy.dominik.peeshquorkeebe.database;

// localhost postgres
// userName: peeshko
// password: str0ng_P4ss
// database: peeshquorkee

import java.sql.*;
import java.util.Properties;

public class DatabaseConnection {

    public DatabaseConnection() {
        Properties properties = new Properties();
        properties.setProperty("user", "peeshko");
        properties.setProperty("password", "str0ng_P4ss");
        try {
            String DATABASE_URL = "jdbc:postgresql://192.168.100.24/peeshquorkee";
            Connection connection = DriverManager.getConnection(DATABASE_URL, properties);
            selectUserName(connection);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static String selectUserName(Connection connection) {
        Connection connection1 = connection;
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            if (resultSet.next()) {
                System.out.println(resultSet.getString("nickname"));
            } else
                System.out.println("nothing in db lmao");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return "?";
    }

    public static void main(String[] args) {
        DatabaseConnection databaseConnection = new DatabaseConnection();

    }
}

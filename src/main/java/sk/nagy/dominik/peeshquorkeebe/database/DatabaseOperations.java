package sk.nagy.dominik.peeshquorkeebe.database;

import sk.nagy.dominik.peeshquorkeebe.restapi.chat.ChatHistory;
import sk.nagy.dominik.peeshquorkeebe.restapi.chat.ChatMessageReceived;
import sk.nagy.dominik.peeshquorkeebe.restapi.login.UserLoginRequest;
import sk.nagy.dominik.peeshquorkeebe.restapi.login.UserLoginResponse;
import sk.nagy.dominik.peeshquorkeebe.restapi.register.UserRegisterRequest;
import sk.nagy.dominik.peeshquorkeebe.restapi.register.UserRegisterResponse;

import java.sql.*;

public class DatabaseOperations extends DatabaseConnection implements IDatabaseOperations{

    private final Connection connection;

    public DatabaseOperations() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        connection = databaseConnection.getConnection();
    }

    // POST(/userLogin)
    // in: email, password
    // out: * except pass
    @Override
    public UserLoginResponse userLogin(UserLoginRequest userLoginRequest) {
        String select = "SELECT * FROM users WHERE email = '" +userLoginRequest.getEmail()+ "'AND password = '" +userLoginRequest.getPassword()+ "'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            if (resultSet.next()) {
                connection.close();
                return new UserLoginResponse("Registered", resultSet.getString("ID"),
                        resultSet.getString("nickname"), resultSet.getString("email"), resultSet.getString("avatar"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return new UserLoginResponse("Not Registered");
    }

    @Override
    public ChatHistory lastTenMessages(String timestamp) {
        return null;
    }

    @Override
    public ChatMessageReceived chatMessageReceived(String nickname, String message, String email, Timestamp timestamp) {
        return null;
    }

    @Override
    public UserRegisterResponse userRegisterResponse(UserRegisterRequest userRegisterRequest) {
        return null;
    }
}

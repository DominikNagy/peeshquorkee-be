package sk.nagy.dominik.peeshquorkeebe.database;

import sk.nagy.dominik.peeshquorkeebe.restapi.chat.ChatHistory;
import sk.nagy.dominik.peeshquorkeebe.restapi.chat.ChatMessageReceived;
import sk.nagy.dominik.peeshquorkeebe.restapi.login.UserLoginRequest;
import sk.nagy.dominik.peeshquorkeebe.restapi.login.UserLoginResponse;
import sk.nagy.dominik.peeshquorkeebe.restapi.register.UserRegisterRequest;
import sk.nagy.dominik.peeshquorkeebe.restapi.register.UserRegisterResponse;
import sk.nagy.dominik.peeshquorkeebe.restapi.user.User;

import java.sql.*;

public class DatabaseOperations extends DatabaseConnection implements IDatabaseOperations{

    private final Connection connection;

    public DatabaseOperations() {
        DatabaseConnection databaseConnection = new DatabaseConnection();
        connection = databaseConnection.getConnection();
    }

    // POST (/userLogin)
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
                        resultSet.getString("nickname"), resultSet.getString("email"), resultSet.getInt("avatar"));
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
    public ChatHistory[] lastTenMessages(Timestamp timestamp) {
        String select = "SELECT chat.timestamp, chat.nickname, chat.email, chat.message, avatar\n" +
                "FROM chat INNER JOIN users u on chat.email = u.email\n" +
                "WHERE chat.timestamp < to_timestamp('" +timestamp.toString()+ "', 'YYYY-MM-DD HH24:MI:SS')\n" +
                "ORDER BY timestamp DESC OFFSET 0 ROWS FETCH NEXT 10 ROWS ONLY";

        try {
            return selectChat(select);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }


    // GET (/chatHistoryFull)
    // in ~
    // out: full chat history
    @Override
    public ChatHistory[] fullHistory() {
        String select = "SELECT chat.timestamp, chat.nickname, chat.email, chat.message, avatar\n" +
                "FROM chat INNER JOIN users u on chat.email = u.email\n" +
                "ORDER BY timestamp";

        try {
            //selectChat(select);
            ChatHistory[] chatHistories = selectChat(select);
            connection.close();
            return chatHistories;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private ChatHistory[] selectChat(String select) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(select,
                ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSet = statement.executeQuery();
        resultSet.last();
        ChatHistory[] chatHistories = new ChatHistory[resultSet.getRow()];
        resultSet.beforeFirst();
        int i = 0;
        while (resultSet.next()) {
            chatHistories[i] = new ChatHistory(
                    resultSet.getTimestamp("timestamp"),
                    resultSet.getString("nickname"),
                    resultSet.getString("message"),
                    resultSet.getString("email"));
            i += 1;
        }

        return chatHistories;
    }

    // on new message this method is called
    // inserts new messages to chat table
    @Override
    public ChatMessageReceived chatMessageReceived(String nickname, String message, String email) {
        String insert = "INSERT INTO chat (nickname, message, email) \n" +
                "VALUES ('" +nickname+ "', '" +message+ "', '" +email+ "') ";

        try {
            Statement statement = connection.createStatement();
            int resultSet = statement.executeUpdate(insert);
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


        return null;
    }

    // POST (/userLogin)
    // in: email, password
    // out: * except pass
    @Override
    public UserRegisterResponse userRegisterResponse(UserRegisterRequest userRegisterRequest) {
        String insert = "INSERT INTO users (nickname, email, password, avatar) " +
                "VALUES ('" +userRegisterRequest.getNickname()+ "', '" +userRegisterRequest.getEmail()+ "', '"
                +userRegisterRequest.getPassword()+ "', '" +userRegisterRequest.getAvatar()+ "')";

        try {
            Statement statement = connection.createStatement();
            int resultSet = statement.executeUpdate(insert);
            connection.close();
            return new UserRegisterResponse("Success.");
        } catch (SQLException throwables) {
            if (throwables.getErrorCode() == 0) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return new UserRegisterResponse("User already exists.");
            }
            else {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                return new UserRegisterResponse("Something went wrong.");
            }
        }
    }


    // GET (/user)
    // in: email
    // out: *
    @Override
    public User getUser(String email) {
        String select = "select * from users where email = '" +email+ "'";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(select);
            if (resultSet.next()) {
                connection.close();
                return new User(resultSet.getInt("id"), resultSet.getString("nickname"),
                        resultSet.getString("email"), resultSet.getString("password"),
                        resultSet.getInt("avatar"), resultSet.getTimestamp("createdat"),
                        resultSet.getTimestamp("updatedat"));
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public User[] getAllUsers() {
        String select = "select * from users";

        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(select,
                    ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet resultSet = statement.executeQuery();
            resultSet.last();

            // getRow gets the number of rows
            User[] users = new User[resultSet.getRow()];
            resultSet.beforeFirst();
            int i = 0;
            while (resultSet.next()) {
                users[i] = new User(resultSet.getInt("id"), resultSet.getString("nickname"),
                        resultSet.getString("email"), resultSet.getString("password"),
                        resultSet.getInt("avatar"), resultSet.getTimestamp("createdat"),
                        resultSet.getTimestamp("updatedat"));
                i += 1;
            }
            connection.close();
            return users;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
}

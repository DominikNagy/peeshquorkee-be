package sk.nagy.dominik.peeshquorkeebe.database;

import sk.nagy.dominik.peeshquorkeebe.restapi.chat.ChatHistory;
import sk.nagy.dominik.peeshquorkeebe.restapi.chat.ChatMessageReceived;
import sk.nagy.dominik.peeshquorkeebe.restapi.game.GamesResponse;
import sk.nagy.dominik.peeshquorkeebe.websocket.game.GameResult;
import sk.nagy.dominik.peeshquorkeebe.restapi.login.UserLoginRequest;
import sk.nagy.dominik.peeshquorkeebe.restapi.login.UserLoginResponse;
import sk.nagy.dominik.peeshquorkeebe.restapi.register.UserRegisterRequest;
import sk.nagy.dominik.peeshquorkeebe.restapi.register.UserRegisterResponse;
import sk.nagy.dominik.peeshquorkeebe.restapi.user.User;

import java.sql.Timestamp;

public interface IDatabaseOperations {
    UserLoginResponse userLogin(UserLoginRequest userLoginRequest);
    ChatHistory[] lastTenMessages(String timestamp);
    ChatHistory[] fullHistory();
    ChatMessageReceived chatMessageReceived(String nickname, String message, String email);
    UserRegisterResponse userRegisterResponse(UserRegisterRequest userRegisterRequest);
    User getUser(String email);
    User[] getAllUsers();
    void insertGameResult(GameResult gameResult);
    GamesResponse getGame(String playerNick);
    GamesResponse[] getAllGames();
}

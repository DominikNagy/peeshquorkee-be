package sk.nagy.dominik.peeshquorkeebe.websocket.game;

public class GameResult {
    private final String playerOneNick;
    private final String playerTwoNick;
    private final String gameboard;

    public GameResult(String playerOneNick, String playerTwoNick, String gameboard) {
        this.playerOneNick = playerOneNick;
        this.playerTwoNick = playerTwoNick;
        this.gameboard = gameboard;
    }

    public String getPlayerOneNick() {
        return playerOneNick;
    }

    public String getPlayerTwoNick() {
        return playerTwoNick;
    }

    public String getGameboard() {
        return gameboard;
    }
}

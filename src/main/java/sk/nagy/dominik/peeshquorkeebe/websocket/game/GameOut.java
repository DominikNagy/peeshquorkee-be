package sk.nagy.dominik.peeshquorkeebe.websocket.game;

import java.util.List;

public class GameOut {
    private boolean winner;
    private String winnerNick;
    private List<String> gameBoard;

    public GameOut() {
    }

    public GameOut(List<String> gameBoard, boolean winner, String winnerNick) {
        this.gameBoard = gameBoard;
        this.winner = winner;
        this.winnerNick = winnerNick;
    }

    public List<String> getGameBoard() {
        return gameBoard;
    }

    public void setGameBoard(List<String> gameBoard) {
        this.gameBoard = gameBoard;
    }

    public boolean isWinner() {
        return winner;
    }

    public void setWinner(boolean winner) {
        this.winner = winner;
    }

    public String getWinnerNick() {
        return winnerNick;
    }

    public void setWinnerNick(String winnerNick) {
        this.winnerNick = winnerNick;
    }
}
package sk.nagy.dominik.peeshquorkeebe.websocket.game;

import java.util.List;

public class GameOut {
    private boolean winner;
    private boolean draw;
    private String winnerNick;
    private Board gameBoard;

    public GameOut() {
    }

    public GameOut(List<String> gameBoard, boolean winner, boolean draw, String winnerNick) {
        this.gameBoard = new Board(gameBoard.get(0), gameBoard.get(1), gameBoard.get(2), gameBoard.get(3),
                gameBoard.get(4), gameBoard.get(5), gameBoard.get(6), gameBoard.get(7), gameBoard.get(8));
        this.winner = winner;
        this.draw = draw;
        this.winnerNick = winnerNick;
    }

    public boolean isDraw() {
        return draw;
    }

    public void setDraw(boolean draw) {
        this.draw = draw;
    }

    public Board getGameBoard() {
        return gameBoard;
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
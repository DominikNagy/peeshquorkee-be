package sk.nagy.dominik.peeshquorkeebe.websocket.game;

import java.util.List;

public class GameBoardOUT {
    private boolean winner;
    private String winnerNick;
    private String f00;
    private String f01;
    private String f02;
    private String f10;
    private String f11;
    private String f12;
    private String f20;
    private String f21;
    private String f22;

    public GameBoardOUT() {
    }

    public GameBoardOUT(List<String> currentBoard, boolean winner, String winnerNick) {
        this.f00 = currentBoard.get(0);
        this.f01 = currentBoard.get(1);
        this.f02 = currentBoard.get(2);
        this.f10 = currentBoard.get(3);
        this.f11 = currentBoard.get(4);
        this.f12 = currentBoard.get(5);
        this.f20 = currentBoard.get(6);
        this.f21 = currentBoard.get(7);
        this.f22 = currentBoard.get(8);
        this.winner = winner;
        this.winnerNick = winnerNick;
    }

    public GameBoardOUT(String f00, String f01, String f02, String f10, String f11, String f12, String f20, String f21, String f22) {
        this.f00 = f00;
        this.f01 = f01;
        this.f02 = f02;
        this.f10 = f10;
        this.f11 = f11;
        this.f12 = f12;
        this.f20 = f20;
        this.f21 = f21;
        this.f22 = f22;
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

    public void setF00(String f00) {
        this.f00 = f00;
    }

    public void setF01(String f01) {
        this.f01 = f01;
    }

    public void setF02(String f02) {
        this.f02 = f02;
    }

    public void setF10(String f10) {
        this.f10 = f10;
    }

    public void setF11(String f11) {
        this.f11 = f11;
    }

    public void setF12(String f12) {
        this.f12 = f12;
    }

    public void setF20(String f20) {
        this.f20 = f20;
    }

    public void setF21(String f21) {
        this.f21 = f21;
    }

    public void setF22(String f22) {
        this.f22 = f22;
    }

    public String getF00() {
        return f00;
    }

    public String getF01() {
        return f01;
    }

    public String getF02() {
        return f02;
    }

    public String getF10() {
        return f10;
    }

    public String getF11() {
        return f11;
    }

    public String getF12() {
        return f12;
    }

    public String getF20() {
        return f20;
    }

    public String getF21() {
        return f21;
    }

    public String getF22() {
        return f22;
    }
}
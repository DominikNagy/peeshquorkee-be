package sk.nagy.dominik.peeshquorkeebe.websocket.game;

public class PlayerIN {
    private String nickname;
    private String move;

    public PlayerIN() {
    }

    public PlayerIN(String nickname, String move) {
        this.nickname = nickname;
        this.move = move;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

}

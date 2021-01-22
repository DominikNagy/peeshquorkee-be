package sk.nagy.dominik.peeshquorkeebe.restapi.user;

import java.sql.Timestamp;
import java.util.Base64;

public class User {
    private int id;
    private String nickname;
    private String email;
    private String password;
    private int avatar;
    private Timestamp createdat;
    private Timestamp updatedate;
    private int victories;
    private int gamesPlayed;

    public User() {
    }

    public User(int id, String nickname, String email, String password, int avatar,
                Timestamp createdat, Timestamp updatedate, int victories, int gamesPlayed) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
        this.createdat = createdat;
        this.updatedate = updatedate;
        this.victories = victories;
        this.gamesPlayed = gamesPlayed;
    }

    public int getVictories() {
        return victories;
    }

    public int getGamesPlayed() {
        return gamesPlayed;
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public int getAvatar() {
        return avatar;
    }

    public Timestamp getCreatedat() {
        return createdat;
    }

    public Timestamp getUpdatedate() {
        return updatedate;
    }
}

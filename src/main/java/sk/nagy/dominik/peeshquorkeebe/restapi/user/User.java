package sk.nagy.dominik.peeshquorkeebe.restapi.user;

import java.sql.Timestamp;
import java.util.Base64;

public class User {
    private int id;
    private String nickname;
    private String email;
    private String password;
    private byte[] avatar;
    private Timestamp createdat;
    private Timestamp updatedate;

    public User() {
    }

    public User(int id, String nickname, String email, String password, byte[] avatar, Timestamp createdat, Timestamp updatedate) {
        this.id = id;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.avatar = Base64.getDecoder().decode(avatar);
        this.createdat = createdat;
        this.updatedate = updatedate;
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

    public byte[] getAvatar() {
        return avatar;
    }

    public Timestamp getCreatedat() {
        return createdat;
    }

    public Timestamp getUpdatedate() {
        return updatedate;
    }
}

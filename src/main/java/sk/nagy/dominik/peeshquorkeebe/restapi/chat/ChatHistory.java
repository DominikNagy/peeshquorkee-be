package sk.nagy.dominik.peeshquorkeebe.restapi.chat;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class ChatHistory {
    private String timestamp;
    private String nickname;
    private String message;
    private String email;

    public ChatHistory(Timestamp timestamp, String nickname, String message, String email) {
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp);
        this.nickname = nickname;
        this.message = message;
        this.email = email;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timestamp);
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

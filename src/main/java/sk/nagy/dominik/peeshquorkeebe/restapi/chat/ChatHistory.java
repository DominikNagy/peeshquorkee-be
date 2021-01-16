package sk.nagy.dominik.peeshquorkeebe.restapi.chat;

import java.sql.Timestamp;

public class ChatHistory {
    private Timestamp timestamp;
    private String nickname;
    private String message;
    private String email;

    public ChatHistory(Timestamp timestamp, String nickname, String message, String email) {
        this.timestamp = timestamp;
        this.nickname = nickname;
        this.message = message;
        this.email = email;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
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

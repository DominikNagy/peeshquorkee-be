package sk.nagy.dominik.peeshquorkeebe.websocket.chat;

import java.time.LocalDateTime;

public class AnswerMessage {
    private String content;
    private String nickname;
    private String email;
    private LocalDateTime timestamp;
    private String avatar;

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public AnswerMessage() {
    }

    public AnswerMessage(String content, String nickname, String email, LocalDateTime timestamp, String avatar) {
        this.content = content;
        this.nickname = nickname;
        this.email = email;
        this.timestamp = timestamp;
        this.avatar = avatar;
    }
    public String getContent() {
        return content;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getAvatar() {
        return avatar;
    }
}

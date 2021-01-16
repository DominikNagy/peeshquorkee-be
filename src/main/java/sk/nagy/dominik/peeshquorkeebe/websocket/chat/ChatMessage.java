package sk.nagy.dominik.peeshquorkeebe.websocket.chat;

public class ChatMessage {
    private String message;
    private String nickname;
    private String email;
    private String avatar;

    public ChatMessage() {

    }

    public ChatMessage(String message, String nickname, String email, String avatar) {
        this.message = message;
        this.nickname = nickname;
        this.email = email;
        this.avatar = avatar;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }
}
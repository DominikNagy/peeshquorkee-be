package sk.nagy.dominik.peeshquorkeebe.restapi.chat;

public class ChatMessageReceived {
    private String nickname;
    private String message;
    private String email;

    public ChatMessageReceived(String nickname, String message, String email) {
        this.nickname = nickname;
        this.message = message;
        this.email = email;
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

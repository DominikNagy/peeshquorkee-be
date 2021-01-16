package sk.nagy.dominik.peeshquorkeebe.restapi.login;

// REST API user-login-response
// from db

public class UserLoginResponse {
    // not a response from db (Registered, Not Registered)
    private String user;
    private String userId;
    private String nickname;
    private String email;
    private String avatar;

    public UserLoginResponse(String user, String userId, String nickname, String email, String avatar) {
        this.user = user;
        this.userId = userId;
        this.nickname = nickname;
        this.email = email;
        this.avatar = avatar;
    }

    public UserLoginResponse(String user) {
        this.user = user;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}

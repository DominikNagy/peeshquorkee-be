package sk.nagy.dominik.peeshquorkeebe.restapi.register;

public class UserRegisterRequest {
    private String nickname;
    private String email;
    private String password;
    private int avatar;

    public UserRegisterRequest(String nickname, String email, String password, int avatar) {
        this.nickname = nickname;
        this.email = email;
        this.password = password;
        this.avatar = avatar;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}

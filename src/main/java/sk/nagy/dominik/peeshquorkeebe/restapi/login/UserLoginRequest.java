package sk.nagy.dominik.peeshquorkeebe.restapi.login;

// REST API user-login-request
// to db

public class UserLoginRequest {
    private String email;
    // md5 hash
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

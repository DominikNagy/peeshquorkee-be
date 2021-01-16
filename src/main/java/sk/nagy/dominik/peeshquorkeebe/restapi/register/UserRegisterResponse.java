package sk.nagy.dominik.peeshquorkeebe.restapi.register;

public class UserRegisterResponse {
    private String registration;

    public UserRegisterResponse(String registration) {
        this.registration = registration;
    }

    public String getRegistration() {
        return registration;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }
}

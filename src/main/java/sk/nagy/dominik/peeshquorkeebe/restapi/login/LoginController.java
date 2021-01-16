package sk.nagy.dominik.peeshquorkeebe.restapi.login;

import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @CrossOrigin(originPatterns = "*")
    @PostMapping("/userLogin")
    public UserResponse userResponse() {
        UserResponse userResponse = new UserResponse();

        return userResponse;
    }

}

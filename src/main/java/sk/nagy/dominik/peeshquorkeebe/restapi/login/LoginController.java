package sk.nagy.dominik.peeshquorkeebe.restapi.login;

import org.springframework.web.bind.annotation.*;
import sk.nagy.dominik.peeshquorkeebe.database.DatabaseOperations;

@RestController
public class LoginController {

    @CrossOrigin(originPatterns = "*")
    @PostMapping(path = "/userLogin", consumes = "application/json", produces = "application/json")
    public UserLoginResponse userResponse(@RequestBody UserLoginRequest userLoginRequest) {
        DatabaseOperations databaseOperations = new DatabaseOperations();
        return databaseOperations.userLogin(userLoginRequest);
    }

}

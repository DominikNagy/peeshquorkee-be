package sk.nagy.dominik.peeshquorkeebe.restapi.register;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sk.nagy.dominik.peeshquorkeebe.database.DatabaseOperations;

@RestController
public class RegisterController {

    @CrossOrigin(originPatterns = "*")
    @PostMapping(path = "/userRegister", consumes = "application/json", produces = "application/json")
    public UserRegisterResponse userRegisterResponse(@RequestBody UserRegisterRequest userRegisterRequest) {
        DatabaseOperations databaseOperations = new DatabaseOperations();
        return databaseOperations.userRegisterResponse(userRegisterRequest);
    }
}

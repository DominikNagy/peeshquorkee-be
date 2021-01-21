package sk.nagy.dominik.peeshquorkeebe.restapi.user;

import org.springframework.web.bind.annotation.*;
import sk.nagy.dominik.peeshquorkeebe.database.DatabaseOperations;

@RestController
public class UserController {

    @CrossOrigin(originPatterns = "*")
    @GetMapping(path = "/user", produces = "application/json")
    public User getUser(@RequestParam String email) {
        DatabaseOperations databaseOperations = new DatabaseOperations();
        return databaseOperations.getUser(email);
    }

    @CrossOrigin(originPatterns = "*")
    @GetMapping(path = "/allUsers", produces = "application/json")
    public User[] getAllUsers() {
        DatabaseOperations databaseOperations = new DatabaseOperations();
        return databaseOperations.getAllUsers();
    }
}

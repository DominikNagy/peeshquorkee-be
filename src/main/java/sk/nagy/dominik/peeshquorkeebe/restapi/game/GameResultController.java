package sk.nagy.dominik.peeshquorkeebe.restapi.game;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.nagy.dominik.peeshquorkeebe.database.DatabaseOperations;

@RestController
public class GameResultController {

    @CrossOrigin(originPatterns = "*")
    @GetMapping(path = "/allGames")
    public GamesResponse[] gamesResponse() {
        DatabaseOperations databaseOperations = new DatabaseOperations();
        return databaseOperations.getAllGames();
    }


}

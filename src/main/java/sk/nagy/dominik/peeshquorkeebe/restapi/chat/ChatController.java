package sk.nagy.dominik.peeshquorkeebe.restapi.chat;

import org.springframework.web.bind.annotation.*;
import sk.nagy.dominik.peeshquorkeebe.database.DatabaseOperations;

import java.sql.Timestamp;

@RestController
public class ChatController {

    @CrossOrigin(originPatterns = "*")
    @PostMapping(path = "/chatHistory", consumes = "application/json", produces = "application/json")
    public ChatHistory chatHistory(@RequestBody Timestamp timestamp) {
        DatabaseOperations databaseOperations = new DatabaseOperations();
        return databaseOperations.lastTenMessages(timestamp);
    }

    @CrossOrigin(originPatterns = "*")
    @GetMapping(path = "/chatHistoryFull")
    public ChatHistory[] fullChatHistory() {
        DatabaseOperations databaseOperations = new DatabaseOperations();
        return databaseOperations.fullHistory();
    }
}

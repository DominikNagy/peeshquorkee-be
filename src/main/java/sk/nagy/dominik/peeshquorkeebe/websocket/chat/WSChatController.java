package sk.nagy.dominik.peeshquorkeebe.websocket.chat;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import sk.nagy.dominik.peeshquorkeebe.database.DatabaseOperations;

import java.sql.Timestamp;

@Controller
public class WSChatController {

    @MessageMapping("/incomingMessage")
    @SendTo("/topic/chat")
    public AnswerMessage answerMessage(ChatMessage message) throws Exception {
        String newMessage = HtmlUtils.htmlEscape(message.getMessage());
        String nicknameOfSender = HtmlUtils.htmlEscape(message.getNickname());
        String emailOfSender = HtmlUtils.htmlEscape(message.getEmail());
        String avatarOfSender = HtmlUtils.htmlEscape(message.getAvatar());

        DatabaseOperations databaseConnection = new DatabaseOperations();
        databaseConnection.chatMessageReceived(nicknameOfSender, newMessage, emailOfSender);

        Timestamp timestampNow = new Timestamp(System.currentTimeMillis());

        return new AnswerMessage(newMessage, nicknameOfSender, emailOfSender, timestampNow.toLocalDateTime(), avatarOfSender);
    }
}

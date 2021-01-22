package sk.nagy.dominik.peeshquorkeebe.websocket.chat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

import sk.nagy.dominik.peeshquorkeebe.database.DatabaseOperations;

import java.security.Principal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class WSChatController {
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/incomingMessage")
    @SendTo("/topic/chat")
    public AnswerMessage answerMessage(ChatMessage message) throws Exception {
        String newMessage = HtmlUtils.htmlEscape(message.getMessage());
        String nicknameOfSender = HtmlUtils.htmlEscape(message.getNickname());
        String emailOfSender = HtmlUtils.htmlEscape(message.getEmail());
        int avatarOfSender = message.getAvatar();

        DatabaseOperations databaseConnection = new DatabaseOperations();
        databaseConnection.chatMessageReceived(nicknameOfSender, newMessage, emailOfSender);

        Timestamp timestampNow = new Timestamp(System.currentTimeMillis());

        return new AnswerMessage(newMessage, nicknameOfSender, emailOfSender, timestampNow.toLocalDateTime(), avatarOfSender);
    }

    @MessageMapping("/user/queue")
    public void sendSpecific(Principal user, @Header("simpSessionId") String sessionId) throws Exception {
        System.out.println("received message from " +user.getName());
        simpMessagingTemplate.convertAndSendToUser(user.getName(), "/user/queue/reply", "yo");
    }
}

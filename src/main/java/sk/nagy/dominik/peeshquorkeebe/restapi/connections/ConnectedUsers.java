package sk.nagy.dominik.peeshquorkeebe.restapi.connections;

import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@RestController
public class ConnectedUsers {
    private int online = 0;

    @CrossOrigin(originPatterns = "*")
    @GetMapping(path = "/online")
    public OnlineUsers onlineUsers() {
        return new OnlineUsers(online);
    }

    public void setOnline(int online) {
        this.online = online;
    }

    @EventListener(SessionConnectEvent.class)
    public void handleWebsocketConnectListner(SessionConnectEvent event) {
        online++;
    }

    @EventListener(SessionDisconnectEvent.class)
    public void handleWebsocketDisconnectListner(SessionDisconnectEvent event) {
        online--;
    }
}

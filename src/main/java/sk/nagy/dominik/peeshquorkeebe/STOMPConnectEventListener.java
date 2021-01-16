package sk.nagy.dominik.peeshquorkeebe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.messaging.SessionConnectEvent;

@Service
public class STOMPConnectEventListener implements ApplicationListener<SessionConnectEvent> {

    @Override
    public void onApplicationEvent(SessionConnectEvent sessionConnectEvent) {
        StompHeaderAccessor sha = StompHeaderAccessor.wrap(sessionConnectEvent.getMessage());

        String sessionId = sha.getSessionId();
        System.out.println(sessionId);
    }
}

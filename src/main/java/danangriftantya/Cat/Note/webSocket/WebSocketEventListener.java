package danangriftantya.Cat.Note.webSocket;

import danangriftantya.Cat.Note.note.NoteController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Component
@Slf4j
@RequiredArgsConstructor
public class WebSocketEventListener implements ApplicationListener<SessionConnectEvent>{

    public static final Logger logger = LoggerFactory.getLogger(WebSocketEventListener.class);
    private final SimpMessagingTemplate messagingTemplate;

    @Override
    public void onApplicationEvent(SessionConnectEvent event) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());

        String username = accessor.getUser().getName();
        String sessionId = accessor.getSessionId();

        logger.info("Connected user: {} with sessionId: {}", username, sessionId);
        // Notify all subscribers about the new connection
        messagingTemplate.convertAndSend("/topic/user/" + username + " joined session");
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor accessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = accessor.getUser().getName();
        String sessionId = accessor.getSessionId();

        logger.info("Disconnected user: {} with sessionId: {}", username, sessionId);
        messagingTemplate.convertAndSend("/topic/user/" + username + " left session.");
    }
}

package org.example.api;


import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.infraestructure.event.EventSerializer;
import org.springframework.stereotype.Component;

//@Component
//@ServerEndpoint("/retrieve/{correlationId}")
public class SocketController {
/*
    private static final Logger logger = Logger.getLogger(SocketController.class.getName());
    private static Map<String, Map<String, Session>> sessions;

    public SocketController() {
        if (Objects.isNull(sessions)) {
            sessions = new ConcurrentHashMap<>();
        }
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("correlationId") String correlationId) {
        logger.info("Connect by " + correlationId);
        var map = sessions.getOrDefault(correlationId, new HashMap<>());
        map.put(session.getId(), session);
        sessions.put(correlationId, map);
    }

    @OnClose
    public void onClose(Session session, @PathParam("correlationId") String correlationId) {
        sessions.get(correlationId).remove(session.getId());
        logger.info("Desconnect by " + correlationId);
    }

    @OnError
    public void onError(Session session, @PathParam("correlationId") String correlationId, Throwable throwable) {
        sessions.get(correlationId).remove(session.getId());
        logger.log(Level.SEVERE, throwable.getMessage());
    }

    public void send(String correlationId, DomainEvent event) {
        var message = EventSerializer.instance().serialize(event);
        if (Objects.nonNull(correlationId) && sessions.containsKey(correlationId)) {
            sessions.get(correlationId).values()
                    .forEach(session -> {
                        session.getAsyncRemote().sendText(message);
                    });
        }
    }
*/
}
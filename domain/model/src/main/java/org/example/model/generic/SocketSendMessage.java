package org.example.model.generic;

public interface SocketSendMessage {
    void send(String correlationId, String event);
}

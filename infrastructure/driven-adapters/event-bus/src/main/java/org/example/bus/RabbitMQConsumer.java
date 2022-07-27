package org.example.bus;

import org.example.bus.generic.EventSerializer;
import org.example.bus.generic.SuccessNotificationSerializer;
import org.example.model.generic.SocketSendMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RabbitMQConsumer {

    private final EventListenerSubscriber eventListenerSubscriber;
    private final SocketSendMessage socketSendMessage;
    private static final Logger log = LoggerFactory.getLogger(RabbitMQConsumer.class);

    public RabbitMQConsumer(EventListenerSubscriber eventListenerSubscriber, SocketSendMessage socketSendMessage) {
        this.eventListenerSubscriber = eventListenerSubscriber;
        this.socketSendMessage = socketSendMessage;
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "cardgame.handler", durable = "true"),
            exchange = @Exchange(value = "cardgame", type = "topic"),
            key = "cardgame.#"
    ))
    public void messageReceived(Message<String> message) {
        var successNotification = SuccessNotificationSerializer.instance().deserialize(message.getPayload());
        var event = successNotification.deserializeEvent();
        log.info("Llego este evento: {}", event);
        this.eventListenerSubscriber.onNext(event);
       Optional.ofNullable(event.aggregateParentId()).ifPresentOrElse(id -> {
           socketSendMessage.send(id, EventSerializer.instance().serialize(event));
        }, () -> socketSendMessage.send(event.aggregateRootId(), EventSerializer.instance().serialize(event)));
    }
}

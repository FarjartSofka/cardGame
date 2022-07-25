package org.example.bus;

import co.com.sofka.infraestructure.bus.serialize.SuccessNotificationSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    @Autowired
    private EventListenerSubscriber eventListenerSubscriber;
    @Autowired
   // private SocketController socketController;
    private static final Logger log = LoggerFactory.getLogger(RabbitMQConsumer.class);


    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(value = "cardgame.handler", durable = "true"),
            exchange = @Exchange(value = "cardgame", type = "topic"),
            key = "cardgame.#"
    ))
    public void recievedMessageJuego(Message<String> message) {
        messageShared(message);
    }

    private void messageShared(Message<String> message) {

        var successNotification = SuccessNotificationSerializer.instance().deserialize(message.getPayload());
        var event = successNotification.deserializeEvent();
        log.info("Llego este evento: {}", event);
        /*
        var successNotification = SuccessNotificationSerializer.instance().deserialize(message.getPayload());
        var event = successNotification.deserializeEvent();
        var sb = new StringBuilder("DomainEvent{");
        sb.append("when=").append(event.when);
        sb.append(", uuid=").append(event.uuid);
        sb.append(", type='").append(event.type).append('\'');
        sb.append('}');
        log.info("Event: {}", sb.toString());
        try {
            this.eventListenerSubscriber.onNext(event);
            Optional.ofNullable(event.aggregateParentId())
                    .ifPresentOrElse(id -> socketController.send(id, event), () -> socketController.send(event.aggregateRootId(), event));
        } catch (Exception e) {
            this.eventListenerSubscriber.onError(e);
        }
        */
    }

}

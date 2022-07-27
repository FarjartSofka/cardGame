package org.example.bus;

import org.example.bus.generic.SuccessNotification;
import org.example.bus.generic.SuccessNotificationSerializer;
import org.example.model.generic.DomainEvent;
import org.example.model.generic.EventBus;
import org.example.model.generic.EventRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class RabbitMQEventBus implements EventBus {

    public static final String EXCHANGE = "cardgame";
    private static final String ORIGIN = "cardgame";

    private final EventRepository eventStoreRepository;

    private final RabbitTemplate rabbitTemplate;

    public RabbitMQEventBus(EventRepository eventStoreRepository, RabbitTemplate rabbitTemplate) {
        this.eventStoreRepository = eventStoreRepository;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public Mono<Void> publish(DomainEvent domainEvent) {
        var notification = SuccessNotification.wrapEvent(ORIGIN, domainEvent);
        var notificationSerialization = SuccessNotificationSerializer.instance().serialize(notification);
        rabbitTemplate.convertAndSend(EXCHANGE, domainEvent.type, notificationSerialization.getBytes());
        return eventStoreRepository.save(domainEvent, domainEvent.type);

    }

    @Override
    public Mono<Void> publishError(Throwable errorEvent) {

        return Mono.empty();
    }

}



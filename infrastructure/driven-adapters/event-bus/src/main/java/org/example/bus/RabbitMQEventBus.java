package org.example.bus;

import co.com.sofka.business.generic.BusinessException;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.infraestructure.bus.EventBus;
import co.com.sofka.infraestructure.bus.notification.ErrorNotification;
import co.com.sofka.infraestructure.bus.notification.SuccessNotification;
import co.com.sofka.infraestructure.bus.serialize.ErrorNotificationSerializer;
import co.com.sofka.infraestructure.bus.serialize.SuccessNotificationSerializer;
import co.com.sofka.infraestructure.event.ErrorEvent;
import co.com.sofka.infraestructure.repository.EventStoreRepository;
import org.reactivestreams.Subscription;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class RabbitMQEventBus implements EventBus {

    public static final String EXCHANGE = "cardgame";
    private static final String ORIGIN = "cardgame";
    private static final String TOPIC_ERROR = "cardgame.error";
    private static final String TOPIC_BUSINESS_ERROR = "cardgame.business.error";

    private final EventStoreRepository eventStoreRepository;

    private final MongoTemplate mongoTemplate;
    private static final Logger logger = LoggerFactory.getLogger(RabbitMQEventBus.class.getName());
    private final RabbitTemplate rabbitTemplate;

    public RabbitMQEventBus(EventStoreRepository eventStoreRepository, MongoTemplate mongoTemplate, RabbitTemplate rabbitTemplate) {
        this.eventStoreRepository = eventStoreRepository;
        this.mongoTemplate = mongoTemplate;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void publish(DomainEvent domainEvent) {
        var notification = SuccessNotification.wrapEvent(ORIGIN, domainEvent);
        var notificationSerialization = SuccessNotificationSerializer.instance().serialize(notification);
        rabbitTemplate.convertAndSend(EXCHANGE, domainEvent.type, notificationSerialization.getBytes());
        mongoTemplate.save(domainEvent, domainEvent.type);

    }

    @Override
    public void publishError(ErrorEvent errorEvent) {
        if (errorEvent.error instanceof BusinessException) {
            publishToTopic(TOPIC_BUSINESS_ERROR, errorEvent);
        } else {
            publishToTopic(TOPIC_ERROR, errorEvent);
        }
        logger.error(errorEvent.error.getMessage());

    }


    public void publishToTopic(String topic, ErrorEvent errorEvent) {
        var notification = ErrorNotification.wrapEvent(ORIGIN, errorEvent);
        var notificationSerialization = ErrorNotificationSerializer.instance().serialize(notification);
        rabbitTemplate.convertAndSend(EXCHANGE, errorEvent.identify, notificationSerialization.getBytes());
        logger.warn("###### Error Event published to " + topic);

    }



   /* @Override
    public void publish(DomainEvent domainEvent) {
        var notification = SuccessNotification.wrapEvent(ORIGIN, domainEvent);
        var notificationSerialization = SuccessNotificationSerializer.instance().serialize(notification);
        rabbitTemplate.convertAndSend(EXCHANGE, domainEvent.type, notificationSerialization.getBytes());
        mongoTemplate.save(domainEvent, domainEvent.type);
    }

    @Override
    public void publishError(ErrorEvent errorEvent) {
        if (errorEvent.error instanceof BusinessException) {
            publishToTopic(TOPIC_BUSINESS_ERROR, errorEvent);
        } else {
            publishToTopic(TOPIC_ERROR, errorEvent);
        }
        logger.log(Level.SEVERE, errorEvent.error.getMessage());
    }

    public void publishToTopic(String topic, ErrorEvent errorEvent) {
        var notification = ErrorNotification.wrapEvent(ORIGIN, errorEvent);
        var notificationSerialization = ErrorNotificationSerializer.instance().serialize(notification);
        rabbitTemplate.convertAndSend(EXCHANGE, errorEvent.identify, notificationSerialization.getBytes());
        logger.warning("###### Error Event published to " + topic);
    }*/
}



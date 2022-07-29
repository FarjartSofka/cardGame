package org.example.bus;

import org.example.model.GameContext.event.StartedGame;
import org.example.model.generic.DomainEvent;
import org.example.model.generic.EventBus;
import org.example.model.generic.EventStoreRepository;
import org.example.model.generic.StoredEvent;
import org.example.usecase.generic.UseCaseWrap;
import org.springframework.stereotype.Component;;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.logging.Logger;

@Component
public class EventListenerSubscriber {

    private static final Logger logger = Logger.getLogger(EventListenerSubscriber.class.getName());
    private final Set<UseCaseWrap> useCases;
    private final EventStoreRepository repository;

    private final StoredEvent.EventSerializer eventSerializer;
    private final EventBus eventBus;


    public EventListenerSubscriber(Set<UseCaseWrap> useCases, EventStoreRepository repository, StoredEvent.EventSerializer eventSerializer, EventBus eventBus) {
        this.useCases = useCases;
        this.repository = repository;
        this.eventSerializer = eventSerializer;
        this.eventBus = eventBus;
    }



    public void onNext(DomainEvent domainEvent) {
        DomainEvent event = Objects.requireNonNull(domainEvent);
        logger.info("Llego este evento: " + event);
        this.useCases.stream().filter((useCaseWrap) -> useCaseWrap.getEventType().equals(domainEvent.type)).forEach((useCaseWrap) -> {
           var events = (List<DomainEvent>) useCaseWrap.executeUseCase(domainEvent).collectList();
           events.forEach(domainEvnt-> {
               repository.saveEvent(event.getAggregateName(),
                       event.aggregateRootId(),
                       StoredEvent.wrapEvent(event, eventSerializer)).mergeWith(
                       eventBus.publish(event));
           });
        });
    }


}

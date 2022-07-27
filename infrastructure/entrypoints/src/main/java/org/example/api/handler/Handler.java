package org.example.api.handler;

import org.example.model.generic.DomainEvent;
import org.example.model.generic.EventBus;
import org.example.model.generic.EventStoreRepository;
import org.example.model.generic.StoredEvent;
import reactor.core.publisher.Mono;

public abstract class Handler {

    private final EventStoreRepository repository;
    private final StoredEvent.EventSerializer eventSerializer;
    private final EventBus eventBus;

    protected Handler(EventStoreRepository repository, StoredEvent.EventSerializer eventSerializer, EventBus eventBus) {
        this.repository = repository;
        this.eventSerializer = eventSerializer;
        this.eventBus = eventBus;
    }

    public Mono<Void> emit(Mono<DomainEvent> events) {
        return events
                .flatMap(domainEvent ->
                        Mono.defer(() -> this.repository.saveEvent(
                                        domainEvent.getAggregateName(),
                                        domainEvent.aggregateRootId(),
                                        StoredEvent.wrapEvent(domainEvent, eventSerializer)
                                ).mergeWith(Mono.defer(() -> this.eventBus.publish(domainEvent))).then()
                        )
                );
    }
}

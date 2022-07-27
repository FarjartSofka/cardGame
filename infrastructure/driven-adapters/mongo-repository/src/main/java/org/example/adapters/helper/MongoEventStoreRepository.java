package org.example.adapters.helper;


import org.example.model.generic.DomainEvent;
import org.example.model.generic.EventStoreRepository;
import org.example.model.generic.StoredEvent;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Comparator;

@Component
public class MongoEventStoreRepository implements EventStoreRepository {

    private final ReactiveMongoTemplate mongoTemplate;
    private final StoredEvent.EventSerializer eventSerializer;

    public MongoEventStoreRepository(ReactiveMongoTemplate mongoTemplate, StoredEvent.EventSerializer eventSerializer) {
        this.mongoTemplate = mongoTemplate;
        this.eventSerializer = eventSerializer;
    }

    @Override
    public Flux<DomainEvent> getEventsBy(String aggregateName, String aggregateRootId) {
        var query = new Query(Criteria.where("aggregateRootId").is(aggregateRootId));
        return mongoTemplate.find(query, DocumentEventStored.class, aggregateName)
                .map((documentEventStored -> documentEventStored.getStoredEvent().deserializeEvent(eventSerializer)))
                .sort(Comparator.comparing(DomainEvent::getWhen));
    }

    @Override
    public Mono<Void> saveEvent(String aggregateName, String aggregateRootId, StoredEvent storedEvent) {
        var eventStored = new DocumentEventStored();
        eventStored.setAggregateRootId(aggregateRootId);
        eventStored.setStoredEvent(storedEvent);
        return mongoTemplate.save(eventStored, aggregateName).then();
    }
}
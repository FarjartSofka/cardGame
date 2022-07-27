package org.example.adapters.helper;

import org.example.model.generic.DomainEvent;
import org.example.model.generic.EventRepository;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component

public class MongoEventRepository implements EventRepository {
    private final ReactiveMongoTemplate mongoTemplate;

    public MongoEventRepository(ReactiveMongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Mono<Void> save(DomainEvent domainEvent, String type) {
        return mongoTemplate.save(domainEvent, type).then();
    }
}

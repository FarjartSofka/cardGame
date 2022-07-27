package org.example.model.generic;

import reactor.core.publisher.Mono;

public interface EventRepository {
    Mono<Void> save(DomainEvent domainEvent, String type);
}

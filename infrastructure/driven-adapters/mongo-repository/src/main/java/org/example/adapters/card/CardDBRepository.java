package org.example.adapters.card;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface CardDBRepository extends ReactiveCrudRepository<CardDocument, String> {

    Mono<CardDocument> findByExp(Long exp);

}

package org.example.model.user.gateway;

import org.example.model.card.Card;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {

    Mono<Card> findById(String id);

    Flux<Card> findAll();

}

package org.example.model.UserContext.user.gateway;

import org.example.model.CardContext.card.Card;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserRepository {

    Mono<Card> findById(String id);

    Flux<Card> findAll();

}

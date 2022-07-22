package org.example.model.player.gateway;

import org.example.model.card.Card;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlayerRepository {

    Mono<Card> findById(String id);

    Flux<Card> findAll();

}

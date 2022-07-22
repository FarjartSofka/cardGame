package org.example.model.GameContext.player.gateway;

import org.example.model.CardContext.card.Card;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PlayerRepository {

    Mono<Card> findById(String id);

    Flux<Card> findAll();

}

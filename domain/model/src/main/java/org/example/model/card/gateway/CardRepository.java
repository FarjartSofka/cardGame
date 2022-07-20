package org.example.model.card.gateway;

import org.example.model.card.Card;
import reactor.core.publisher.Mono;

public interface CardRepository {

    Mono<Card> findById(String id);

}


package org.example.model.gateway;

import org.example.model.Card;
import reactor.core.publisher.Mono;

public interface CardRepository {

    Mono<Card> findById(String id);

}


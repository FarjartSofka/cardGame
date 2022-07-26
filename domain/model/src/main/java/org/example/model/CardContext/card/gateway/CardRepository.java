package org.example.model.CardContext.card.gateway;

import org.example.model.CardContext.card.Card;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CardRepository {

    Mono<Card> findById(String id);

    Flux<Card> findAll();

    Mono<Card> save(Card card);

    Flux<Card> saveAll(Flux<Card> cards);

    Mono<Card> findByExp(Long exp);

}


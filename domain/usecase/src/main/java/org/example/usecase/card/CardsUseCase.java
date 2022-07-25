package org.example.usecase.card;

import org.example.model.CardContext.card.Card;
import org.example.model.CardContext.card.gateway.CardRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class CardsUseCase {

    private final CardRepository cardRepository;

    public CardsUseCase(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Mono<Card> save(Card card) { return cardRepository.save(card);}

    public Flux<Card> saveAll(Flux<Card> card) { return cardRepository.saveAll(card);}


    public Flux<Card> allCards() {
        return cardRepository.findAll();

    }

    public Mono<Card> cardById(String id) {
        return cardRepository.findById(id);
    }

}

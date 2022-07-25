package org.example.usecase;

import org.example.model.CardContext.card.Card;
import org.example.model.CardContext.card.gateway.CardRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class ProcessCardUseCase {

    private final CardRepository cardRepository;

    public ProcessCardUseCase(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Flux<Card> allCards() { return cardRepository.findAll(); }

    public Mono<Card> cardById(String id){ return cardRepository.findById(id); }

    public Mono<Card> save(Card card){
        return cardRepository.save(card);
    }

}

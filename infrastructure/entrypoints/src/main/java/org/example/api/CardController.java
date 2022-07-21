package org.example.api;

import org.example.model.card.Card;
import org.example.usecase.ProcessCardUseCase;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RestController
@RequestMapping("/card")
public class CardController {

    private final ProcessCardUseCase processCardUseCase;


    public CardController(ProcessCardUseCase processCardUseCase) {
        this.processCardUseCase = processCardUseCase;
    }

    @GetMapping("/all")
    public Flux<Card> allCards(){ return processCardUseCase.allCards(); }

    @GetMapping("card/{id}")
    public Mono<Card> cardById(@PathVariable("id") String cardId){ return processCardUseCase.cardById(cardId); }
}

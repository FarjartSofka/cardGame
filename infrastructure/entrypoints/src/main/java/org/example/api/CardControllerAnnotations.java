package org.example.api;

import org.example.model.CardContext.card.Card;
import org.example.usecase.card.CardsUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.net.URI;

//@RestController
//@Component
//@RequestMapping("/card")
public class CardControllerAnnotations {
/*
    private final CardsUseCase useCase;

    public CardControllerAnnotations(CardsUseCase useCase) {
        this.useCase = useCase;
    }

    @PostMapping("/create")
    public Mono<Card> createPet(@RequestBody Card card) {
        return useCase.save(card);
    }

    @GetMapping("/all")
    public Flux<Card> allPets() {
        return useCase.findAll();
    }

    @GetMapping("/{id}")
    public Mono<Card> petById(@PathVariable("id") String petId) {
        return useCase.findById(petId);
    }
*/
}

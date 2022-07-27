package org.example.api.handler;

import co.com.sofka.infraestructure.asyn.SubscriberEvent;
import co.com.sofka.infraestructure.repository.EventStoreRepository;
import org.example.model.CardContext.card.Card;
import org.example.usecase.card.CardsUseCase;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.springframework.web.reactive.function.BodyInserters.fromValue;

@Component
public class CardHandler {

    private final CardsUseCase useCase;

    private  EventStoreRepository eventStoreRepository;
    private  SubscriberEvent subscriberEvent;

    public CardHandler(CardsUseCase useCase, EventStoreRepository eventStoreRepository, SubscriberEvent subscriberEvent) {
        this.useCase = useCase;
        this.eventStoreRepository = eventStoreRepository;
        this.subscriberEvent = subscriberEvent;
    }

    public Mono<ServerResponse> save(ServerRequest request){
        var carta = request.bodyToMono(Card.class);

        return carta.flatMap(card -> {
            return useCase.save(card)
                    .flatMap(cardCreate -> ServerResponse
                            .created(URI.create("/card/create".concat(cardCreate.getId())))
                            .contentType(MediaType.APPLICATION_JSON)
                            .body(fromValue(cardCreate)));
        });
    }

    public Mono<ServerResponse> findAll(ServerRequest request){
        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(useCase.allCards(), Card.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request){
        var id = request.pathVariable("id");
        return useCase.cardById(id)
                .flatMap(card -> ServerResponse
                        .ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(fromValue(card)))
                .switchIfEmpty(ServerResponse.notFound().build());
    }

    public Mono<ServerResponse> saveAll(ServerRequest request){
        var carta = request.bodyToFlux(Card.class);

        return ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(useCase.saveAll(carta), Card.class);




    }



}



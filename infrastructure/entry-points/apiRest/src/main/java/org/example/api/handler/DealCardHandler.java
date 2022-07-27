package org.example.api.handler;

import org.example.model.GameContext.command.DealCardsCommand;
import org.example.usecase.game.DealCardsUseCase;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class DealCardHandler {

    private final DealCardsUseCase useCase;

    public DealCardHandler(DealCardsUseCase useCase) {
        this.useCase = useCase;
    }

    public Mono<ServerResponse> dealCards(ServerRequest serverRequest){
        var command = serverRequest.bodyToFlux(DealCardsCommand.class);

        return command.flatMap( dealCardsCommand -> useCase.apply(dealCardsCommand)).collectList()
                .flatMap(list -> ServerResponse.ok().body(BodyInserters.fromValue(list)));
    }

}

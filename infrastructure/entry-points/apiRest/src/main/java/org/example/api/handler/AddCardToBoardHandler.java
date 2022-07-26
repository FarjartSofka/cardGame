package org.example.api.handler;

import org.example.model.GameContext.command.AddCardToBoardCommand;
import org.example.model.generic.EventBus;
import org.example.model.generic.EventStoreRepository;
import org.example.model.generic.StoredEvent;
import org.example.usecase.game.AddCardToBoardUseCase;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class AddCardToBoardHandler extends Handler{
    private final AddCardToBoardUseCase useCase;

    public AddCardToBoardHandler(EventStoreRepository repository, StoredEvent.EventSerializer eventSerializer, EventBus eventBus, AddCardToBoardUseCase useCase) {
        super(repository, eventSerializer, eventBus);
        this.useCase = useCase;
    }


    public Mono<ServerResponse> add(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(AddCardToBoardCommand.class)
                .flatMapMany(this.useCase::apply)
                .flatMap(domainEvent -> emit(Mono.just(domainEvent)))
                .then(ServerResponse
                        .status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .build());
    }

}

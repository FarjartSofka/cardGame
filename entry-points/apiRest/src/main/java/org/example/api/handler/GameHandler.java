package org.example.api.handler;
import org.example.model.GameContext.command.CreateGameCommand;
import org.example.model.generic.EventBus;
import org.example.model.generic.EventStoreRepository;
import org.example.model.generic.StoredEvent;
import org.example.usecase.game.CreateGameUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class GameHandler extends Handler {
    private final CreateGameUseCase createGameUseCase;

    public GameHandler(CreateGameUseCase createGameUseCase, EventStoreRepository repository, StoredEvent.EventSerializer eventSerializer, EventBus eventBus) {
        super(repository, eventSerializer,eventBus);
        this.createGameUseCase = createGameUseCase;
    }

    public Mono<ServerResponse> save(ServerRequest request) {

       var requestMono = request.bodyToMono(CreateGameCommand.class);

       return  requestMono.flatMapMany(this.createGameUseCase)
               .flatMap(domainEvent -> emit(Mono.just(domainEvent)))
               .then(ServerResponse
                       .status(HttpStatus.CREATED)
                       .contentType(MediaType.APPLICATION_JSON)
                       .body(requestMono, CreateGameCommand.class));

    }
}

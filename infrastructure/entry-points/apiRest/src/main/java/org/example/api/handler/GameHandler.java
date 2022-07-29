package org.example.api.handler;
import org.example.model.GameContext.command.CreateGameCommand;
import org.example.model.GameContext.command.DefineWinnerCommand;
import org.example.model.GameContext.command.StartGameCommand;
import org.example.model.generic.EventBus;
import org.example.model.generic.EventStoreRepository;
import org.example.model.generic.StoredEvent;
import org.example.usecase.game.CreateGameUseCase;
import org.example.usecase.game.DefinedWinnerUseCase;
import org.example.usecase.game.StartGameUseCase;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class GameHandler extends Handler {
    private final CreateGameUseCase createGameUseCase;

    private final StartGameUseCase startGameUseCase;

    private final DefinedWinnerUseCase definedWinnerUseCase;

    public GameHandler(CreateGameUseCase createGameUseCase, EventStoreRepository repository, StoredEvent.EventSerializer eventSerializer, EventBus eventBus, StartGameUseCase startGameUseCase, DefinedWinnerUseCase definedWinnerUseCase) {
        super(repository, eventSerializer,eventBus);
        this.createGameUseCase = createGameUseCase;
        this.startGameUseCase = startGameUseCase;
        this.definedWinnerUseCase = definedWinnerUseCase;
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

    public Mono<ServerResponse> start(ServerRequest request) {

        var requestMono = request.bodyToMono(StartGameCommand.class);

        return  requestMono.flatMapMany(this.startGameUseCase::apply)
                .flatMap(domainEvent -> emit(Mono.just(domainEvent)))
                .then(ServerResponse
                        .status(HttpStatus.CREATED)
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(requestMono, CreateGameCommand.class));

    }

    public Mono<ServerResponse> defineWinner(ServerRequest request ){
        return request.bodyToMono(DefineWinnerCommand.class)
                .map(this.definedWinnerUseCase::apply)
                .flatMap(defineWinnerCommand -> ServerResponse.ok()
                        .body(BodyInserters.fromValue(defineWinnerCommand)));





    }

}

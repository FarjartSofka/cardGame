package org.example.api.handler;
import org.example.model.GameContext.command.CreateGameCommand;
import org.example.usecase.game.CreateGameUseCase;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

public class GameHandler {

    private final CreateGameUseCase createGameUseCase;



    public GameHandler(CreateGameUseCase createGameUseCase) {
        this.createGameUseCase = createGameUseCase;
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        var command = request.bodyToFlux(CreateGameCommand.class);

       return command.flatMap(createGameUseCase::apply).collectList()
                .flatMap(list -> ServerResponse.ok().body(BodyInserters.fromValue(list)));



    }
}

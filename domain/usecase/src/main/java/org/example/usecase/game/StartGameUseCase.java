package org.example.usecase.game;

import org.example.model.GameContext.command.StartGameCommand;
import org.example.model.GameContext.game.Game;
import org.example.model.GameContext.game.values.GameId;
import org.example.model.GameContext.game.values.GameState;
import org.example.model.generic.DomainEvent;
import org.example.model.generic.EventStoreRepository;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class StartGameUseCase implements Function<StartGameCommand, Flux<DomainEvent>> {

    private final EventStoreRepository repository;

    public StartGameUseCase(EventStoreRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<DomainEvent> apply(StartGameCommand command) {
        return this.repository.getEventsBy("cardgame", command.getGameId().toString())
                .collectList()
                .flatMapMany(events -> {
                    var game = Game.from(GameId.of(command.getGameId()), events);
                    if (!game.getState().equals(GameState.States.IN_GAME)) {
                        game.startGame(GameId.of(command.getGameId())) ;
                    }
                    return Flux.fromIterable(game.getUncommittedChanges());
                });
    }

}

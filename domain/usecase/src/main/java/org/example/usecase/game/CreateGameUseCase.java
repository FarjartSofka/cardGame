package org.example.usecase.game;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.model.GameContext.command.CreateGameCommand;
import org.example.model.GameContext.game.Game;
import org.example.model.GameContext.game.values.GameId;
import reactor.core.publisher.Flux;
import java.util.function.Function;

public class CreateGameUseCase implements Function<CreateGameCommand, Flux<DomainEvent>> {
    @Override
    public Flux<DomainEvent> apply(CreateGameCommand createGameCommand) {
        var game = new Game(
                GameId.of(createGameCommand.getGameId()),
                        createGameCommand.getPlayersId()
        );
        return  Flux.fromIterable(game.getUncommittedChanges());

   }

}


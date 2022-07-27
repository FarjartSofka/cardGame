package org.example.usecase.game;

import org.example.model.generic.DomainEvent;
import org.example.model.GameContext.command.CreateGameCommand;
import org.example.model.GameContext.game.Game;
import org.example.model.GameContext.game.values.GameId;
import org.example.model.GameContext.player.values.Nickname;
import org.example.model.GameContext.player.values.PlayerId;
import org.example.model.generic.EventBus;
import reactor.core.publisher.Flux;
import java.util.function.Function;

public class CreateGameUseCase implements Function<CreateGameCommand, Flux<DomainEvent>> {

    private final EventBus eventBus;


    public CreateGameUseCase(EventBus eventBus) {
        this.eventBus = eventBus;

    }

    @Override
    public Flux<DomainEvent> apply(CreateGameCommand createGameCommand) {
        var game = new Game(
                GameId.of(createGameCommand.getGameId())
        );

        createGameCommand.getPlayersId().forEach((k,v)-> game.addPlayer(PlayerId.of(k), new Nickname(v)));


        game.getUncommittedChanges().forEach(eventBus::publish);





        return Flux.fromIterable(game.getUncommittedChanges());


   }

}


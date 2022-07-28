package org.example.model.GameContext.event;

import org.example.model.GameContext.game.values.GameId;
import org.example.model.generic.DomainEvent;

public class StartedGame extends DomainEvent {

    public static final String EVENT_TYPE = "cardgame.StartedGane";

    private final GameId gameId;


    public StartedGame(GameId gameId) {
        super(EVENT_TYPE);
        this.gameId = gameId;
    }

    public GameId getGameId() {
        return gameId;
    }
}

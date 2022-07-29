package org.example.model.GameContext.event;

import org.example.model.GameContext.game.values.GameId;
import org.example.model.generic.DomainEvent;

public class StartedGame extends DomainEvent {

    public static final String EVENT_TYPE = "cardgame.StartedGame";

    private final String gameId;


    public StartedGame(String gameId) {
        super(EVENT_TYPE);
        this.gameId = gameId;
    }

    public String getGameId() {
        return gameId;
    }
}

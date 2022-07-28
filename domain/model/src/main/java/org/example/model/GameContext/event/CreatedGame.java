package org.example.model.GameContext.event;

import org.example.model.GameContext.game.values.GameState;
import org.example.model.generic.DomainEvent;

public class CreatedGame extends DomainEvent {
    public static final String EVENT_TYPE = "cardgame.CreatedGame";

    public CreatedGame() {
        super(EVENT_TYPE);
    }

}

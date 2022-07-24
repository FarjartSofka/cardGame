package org.example.model.GameContext.event;

import co.com.sofka.domain.generic.DomainEvent;

public class CreatedGame extends DomainEvent {

    public static final String EVENT_TYPE = "cardgame.CreatedGame";

    public CreatedGame() {
        super(EVENT_TYPE);
    }
}

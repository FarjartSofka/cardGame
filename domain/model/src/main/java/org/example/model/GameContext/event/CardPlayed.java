package org.example.model.GameContext.event;

import co.com.sofka.domain.generic.DomainEvent;

import java.util.UUID;

public class CardPlayed extends DomainEvent {

    private final String playerId;

    private final String cardId;

    public CardPlayed(String playerId, String cardId) {
        super("cardgame.CardPlayed");
        this.playerId = playerId;
        this.cardId = cardId;
    }
}

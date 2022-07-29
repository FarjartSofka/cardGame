package org.example.model.GameContext.event;

import org.example.model.generic.DomainEvent;

public class CardPlayed extends DomainEvent {

    private final String playerId;

    private final String cardId;

    public CardPlayed(String playerId, String cardId) {
        super("cardgame.CardPlayed");
        this.playerId = playerId;
        this.cardId = cardId;
    }

    public String getPlayerId() {  return playerId; }

    public String getCardId() { return cardId; }
}

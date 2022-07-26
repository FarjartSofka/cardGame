package org.example.model.GameContext.event;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.model.GameContext.card.Card;
import org.example.model.GameContext.card.values.CardId;
import org.example.model.GameContext.player.values.PlayerId;

public class CardRemoved extends DomainEvent {

    private final PlayerId playerId;

    private final Card card;

    public CardRemoved(PlayerId playerId, Card cardId) {
        super("cardgame.CardRemoved");
        this.playerId = playerId;
        this.card = cardId;
    }

    public PlayerId getPlayerId() { return playerId; }

    public Card getCard() { return card; }
}

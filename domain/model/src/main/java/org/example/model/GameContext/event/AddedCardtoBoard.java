package org.example.model.GameContext.event;


import org.example.model.GameContext.card.Card;
import org.example.model.GameContext.player.values.PlayerId;
import org.example.model.generic.DomainEvent;

public class AddedCardtoBoard extends DomainEvent {

    private final PlayerId playerId;

    private final Card cards;

    public AddedCardtoBoard(PlayerId playerId, Card cards) {
        super("cardGame.AddedCardtoBoard");
        this.playerId = playerId;
        this.cards = cards;
    }

    public PlayerId getPlayerId() { return playerId; }

    public Card getCards() { return cards; }
}

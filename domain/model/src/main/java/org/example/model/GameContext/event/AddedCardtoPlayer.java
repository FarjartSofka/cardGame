package org.example.model.GameContext.event;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.model.GameContext.player.values.CardsOnDeck;
import org.example.model.GameContext.player.values.PlayerId;

public class AddedCardtoBoard extends DomainEvent {
    public static final String EVENT_TYPE = "cardgame.AddedBoardCard";
    private final PlayerId playerId;
    private final CardsOnDeck deck;

    public AddedCardtoBoard(PlayerId playerId, CardsOnDeck deck) {
        super(EVENT_TYPE);
        this.playerId = playerId;
        this.deck = deck;
    }

    public PlayerId getPlayerId() {
        return playerId;
    }

    public CardsOnDeck getCardsOnDeck() {
        return deck;
    }
}

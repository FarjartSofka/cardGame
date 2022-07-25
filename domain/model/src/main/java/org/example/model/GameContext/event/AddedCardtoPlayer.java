package org.example.model.GameContext.event;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.model.GameContext.player.values.CardsOnDeck;
import org.example.model.GameContext.player.values.PlayerId;

public class AddedCardtoPlayer extends DomainEvent {
    public static final String EVENT_TYPE = "cardgame.AddedCardtoPlayer";
    private final PlayerId playerId;
    private final CardsOnDeck deck;

    public AddedCardtoPlayer(PlayerId playerId, CardsOnDeck deck) {
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

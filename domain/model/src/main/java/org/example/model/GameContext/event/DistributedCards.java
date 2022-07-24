package org.example.model.GameContext.event;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.model.GameContext.player.values.CardsOnDeck;
import org.example.model.GameContext.player.values.PlayerId;

import java.util.Set;

public class DistributedCards extends DomainEvent {
    public static final String EVENT_TYPE = "cardgame.DistributedCards";
    private final PlayerId playerId;

    private final Set<CardsOnDeck> deck;

    public DistributedCards(PlayerId playerId, Set<CardsOnDeck> deck) {
        super(EVENT_TYPE);
        this.playerId = playerId;
        this.deck = deck;
    }

    public PlayerId getPlayerId() {
        return playerId;
    }

    public Set<CardsOnDeck> getGameCards() {
        return deck;
    }
}

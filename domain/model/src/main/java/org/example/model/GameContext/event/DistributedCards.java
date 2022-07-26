package org.example.model.GameContext.event;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.model.GameContext.card.Card;
import org.example.model.GameContext.game.values.GameId;
import org.example.model.GameContext.player.values.PlayerId;

import java.util.Set;

public class DistributedCards extends DomainEvent {
    public static final String EVENT_TYPE = "cardgame.DistributedCards";

    private final GameId gameId;
    private final PlayerId playerId;

    private final Set<Card> deck;

    public DistributedCards(GameId gameId, PlayerId playerId, Set<Card> deck) {
        super(EVENT_TYPE);
        this.gameId = gameId;
        this.playerId = playerId;
        this.deck = deck;
    }

    public PlayerId getPlayerId() {
        return playerId;
    }

    public Set<Card> getGameCards() {
        return deck;
    }
}

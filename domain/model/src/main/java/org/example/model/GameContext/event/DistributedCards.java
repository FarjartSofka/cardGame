package org.example.model.GameContext.event;

import org.example.model.generic.DomainEvent;
import org.example.model.GameContext.card.PlayCard;
import org.example.model.GameContext.game.values.GameId;
import org.example.model.GameContext.player.values.PlayerId;

import java.util.Set;

public class DistributedCards extends DomainEvent {
    public static final String EVENT_TYPE = "cardgame.DistributedCards";

    private final GameId gameId;
    private final PlayerId playerId;
    private final Set<PlayCard> deck;

    public DistributedCards(GameId gameId, PlayerId playerId, Set<PlayCard> deck) {
        super(EVENT_TYPE);
        this.gameId = gameId;
        this.playerId = playerId;
        this.deck = deck;
    }

    public PlayerId getPlayerId() {
        return playerId;
    }

    public Set<PlayCard> getGameCards() { return deck; }

    public GameId getGameId() { return gameId; }


}

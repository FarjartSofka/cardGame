package org.example.model.GameContext.event;

import org.example.model.GameContext.card.values.CardId;
import org.example.model.GameContext.game.values.GameId;
import org.example.model.GameContext.round.values.RoundId;
import org.example.model.generic.DomainEvent;
import org.example.model.GameContext.player.values.PlayerId;

import java.util.Set;

public class CardRemoved extends DomainEvent {

    public static final String EVENT_TYPE = "game.CardRemoved";
    private final GameId gameId;
    private final PlayerId winnerId;
    private final Set<PlayerId> loserId;
    private final RoundId roundId;

    public CardRemoved(GameId gameId, PlayerId winnerId, Set<PlayerId> loserId, RoundId roundId) {
        super(EVENT_TYPE);
        this.gameId = gameId;
        this.winnerId = winnerId;
        this.loserId = loserId;
        this.roundId = roundId;
    }

    public GameId getGameId() {
        return gameId;
    }

    public PlayerId getWinnerId() {
        return winnerId;
    }

    public Set<PlayerId> getLoserId() {
        return loserId;
    }

    public RoundId getRoundId() {
        return roundId;
    }
}

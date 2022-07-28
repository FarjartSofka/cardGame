package org.example.model.GameContext.event;

import org.example.model.GameContext.game.values.GameId;
import org.example.model.GameContext.player.values.PlayerId;
import org.example.model.GameContext.round.values.RoundId;
import org.example.model.GameContext.round.values.RoundNumber;
import org.example.model.generic.DomainEvent;

public class FinishedRound extends DomainEvent {

    public static final String EVENT_TYPE = "cardgame.FinishedRound";

    private final RoundId roundId;

    private final GameId gameId;

    private final PlayerId playerId;

    public FinishedRound(RoundId roundId, GameId gameId, PlayerId playerId) {
        super(EVENT_TYPE);
        this.roundId = roundId;
        this.gameId = gameId;
        this.playerId = playerId;
    }

    public RoundId getRoundId() {
        return roundId;
    }

    public GameId getGameId() {
        return gameId;
    }

    public PlayerId getPlayerId() {
        return playerId;
    }
}

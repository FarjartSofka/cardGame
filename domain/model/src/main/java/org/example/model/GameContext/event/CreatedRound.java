package org.example.model.GameContext.event;

import org.example.model.GameContext.game.values.GameId;
import org.example.model.GameContext.round.values.RoundId;
import org.example.model.GameContext.round.values.RoundNumber;
import org.example.model.generic.DomainEvent;

import java.util.UUID;

public class CreatedRound extends DomainEvent {

    public static final String EVENT_TYPE = "game.CreatedRound";

    private final RoundId roundId;

    private final GameId gameId;

    private final RoundNumber roundNumber;

    public CreatedRound(RoundId roundId, GameId gameId, RoundNumber roundNumber) {
        super(EVENT_TYPE);
        this.roundId = roundId;
        this.gameId = gameId;
        this.roundNumber = roundNumber;
    }

    public RoundId getRoundId() { return roundId; }

    public GameId getGameId() { return gameId; }

    public RoundNumber getRoundNumber() { return roundNumber; }
}

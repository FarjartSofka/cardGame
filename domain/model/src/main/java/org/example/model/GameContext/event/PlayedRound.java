package org.example.model.GameContext.event;

import org.example.model.GameContext.player.values.PlayerId;
import org.example.model.GameContext.round.values.RoundId;
import org.example.model.generic.DomainEvent;

import java.util.Set;

public class PlayedRound  extends DomainEvent {

    public static final String EVENT_TYPE = "cardgame.AssignedRoundPlayers";
    private final RoundId roundId;
    private final Set<PlayerId> players;

    public PlayedRound(RoundId roundId, Set<PlayerId> players) {
        super(EVENT_TYPE);
        this.roundId = roundId;
        this.players = players;
    }

    public RoundId getRoundId() {
        return roundId;
    }

    public Set<PlayerId> getPlayers() {
        return Set.copyOf(players);
    }

}

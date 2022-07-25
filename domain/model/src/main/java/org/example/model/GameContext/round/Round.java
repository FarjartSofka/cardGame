package org.example.model.GameContext.round;

import co.com.sofka.domain.generic.Entity;
import org.example.model.GameContext.player.values.PlayerId;
import org.example.model.GameContext.round.values.RoundId;
import org.example.model.GameContext.round.values.RoundNumber;

import java.util.Set;

public class Round extends Entity<RoundId> {

    private Set<PlayerId> players;

    private RoundNumber number;

    public Round(RoundId entityId, Set<PlayerId> players, RoundNumber number) {
        super(entityId);
        this.players = players;
        this.number = number;
    }

    public Set<PlayerId> players() { return players; }

    public RoundNumber number() { return number; }
}

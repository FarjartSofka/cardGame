package org.example.model.GameContext.round;

import org.example.model.CardContext.card.Card;
import org.example.model.GameContext.round.values.RoundState;
import org.example.model.generic.Entity;
import org.example.model.GameContext.player.values.PlayerId;
import org.example.model.GameContext.round.values.RoundId;
import org.example.model.GameContext.round.values.RoundNumber;

import java.util.Map;

public class Round extends Entity<RoundId> {

    private final Map<PlayerId, Card> mapped;

    private final RoundState roundState;

    private RoundNumber number;

    public Round(RoundId entityId, Map<PlayerId, Card> mapped, RoundState roundState, RoundNumber number) {
        super(entityId);
        this.mapped = mapped;
        this.roundState = roundState;
        this.number = number;
    }

    public Map<PlayerId, Card> getMapped() { return mapped; }

    public RoundState getRoundState() {
        return roundState;
    }

    public Integer getNumber() {
        return number.value();
    }
}

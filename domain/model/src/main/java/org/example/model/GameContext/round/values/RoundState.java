package org.example.model.GameContext.round.values;

import org.example.model.generic.ValueObject;

public class RoundState implements ValueObject<RoundState.States> {

    private final RoundState.States state;

    public RoundState(RoundState.States state) {
        this.state = state;
    }
    @Override
    public RoundState.States value() {
        return state;
    }

    public enum States{
        INITIATED,
        FINISHED
    }

}

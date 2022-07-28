package org.example.model.GameContext.game.values;

import org.example.model.generic.ValueObject;


public class GameState implements ValueObject<GameState.States> {

    private final States state;

    public GameState(States state) {
        this.state = state;
    }
    @Override
    public States value() {
        return state;
    }



    public enum States{
        CREATED,
        INITIATED,
        IN_GAME,
        FINISHED
    }
}

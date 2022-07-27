package org.example.model.GameContext.game.values;

import org.example.model.generic.Identity;

public class GameId extends Identity {
    public GameId() {
    }

    private GameId(String id) {
        super(id);
    }

    public static GameId of(String id) {
        return new GameId(id);
    }
}
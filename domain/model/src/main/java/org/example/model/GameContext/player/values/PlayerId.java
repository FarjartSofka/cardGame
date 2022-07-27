package org.example.model.GameContext.player.values;

import org.example.model.generic.Identity;

public class PlayerId extends Identity {

    public PlayerId(String playerId) {
        super(playerId);
    }

    public PlayerId() {
    }

    public static PlayerId of(String playerId) {
        return new PlayerId(playerId);
    }

}

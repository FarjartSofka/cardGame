package org.example.model.GameContext.game;

import co.com.sofka.domain.generic.EventChange;
import org.example.model.GameContext.event.CreatedGame;

import java.util.HashSet;

public class GameEventChange extends EventChange {


    public GameEventChange(Game game) {

        apply((CreatedGame event)-> {
            game.players = new HashSet<>();
            game.round = new HashSet<>();
        });

    }
}

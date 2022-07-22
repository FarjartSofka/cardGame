package org.example.model.GameContext.game;

import co.com.sofka.domain.generic.AggregateEvent;
import org.example.model.GameContext.board.Board;
import org.example.model.GameContext.game.values.GameId;
import org.example.model.GameContext.player.Player;

import java.util.Set;

public class Game extends AggregateEvent<GameId> {

    protected Set<Player> players;

    protected Board board;

    //protected Round round;

    protected Player winner;

    public Game(GameId entityId) {
        super(entityId);
    }
}

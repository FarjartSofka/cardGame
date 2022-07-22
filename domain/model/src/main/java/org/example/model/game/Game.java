package org.example.model.game;

import co.com.sofka.domain.generic.AggregateEvent;
import org.example.model.board.Board;
import org.example.model.game.values.GameId;
import org.example.model.player.Player;

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

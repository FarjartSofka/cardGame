package org.example.model.GameContext.board;

import co.com.sofka.domain.generic.Entity;
import org.example.model.GameContext.board.values.BoardId;
import org.example.model.GameContext.board.values.Time;
import org.example.model.GameContext.player.values.PlayerId;
import org.example.model.CardContext.card.Card;

import java.util.Map;

public class Board extends Entity<BoardId> {

    private final Time time;

    private final Map<PlayerId,Card> mapped;

    public Board(BoardId entityId, Time time, Map<PlayerId, Card> mapped) {
        super(entityId);
        this.time = time;
        this.mapped = mapped;
    }

}

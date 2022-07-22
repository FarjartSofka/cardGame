package org.example.model.board;

import co.com.sofka.domain.generic.Entity;
import org.example.model.board.values.BoardId;
import org.example.model.board.values.Time;
import org.example.model.card.Card;
import org.example.model.player.values.PlayerId;

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

package org.example.model.GameContext.event;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.model.GameContext.board.values.BoardId;

public class CreatedBoard extends DomainEvent {
    public static final String EVENT_TYPE = "cardgame.CreatedBoard";
    private final BoardId boardId;

    public CreatedBoard(BoardId boardId) {
        super(EVENT_TYPE);
        this.boardId = boardId;
    }

    public BoardId getBoardId() {
        return boardId;
    }
}

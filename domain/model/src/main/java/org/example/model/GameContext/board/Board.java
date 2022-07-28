package org.example.model.GameContext.board;

import org.example.model.CardContext.card.Card;
import org.example.model.GameContext.board.values.BoardId;
import org.example.model.GameContext.player.values.PlayerId;
import org.example.model.GameContext.round.Round;
import org.example.model.generic.Entity;

import java.util.Map;

public class Board extends Entity<BoardId> {

    private final Round round;

    private final Map<PlayerId, Card> mapped;

    public Board(BoardId entityId, Round round, Map<PlayerId, Card> mapped) {
        super(entityId);
        this.round = round;
        this.mapped = mapped;
    }

    public Map<PlayerId, Card> cardByPlayer() {
        return Map.copyOf(mapped);
    }

    public void addCard(PlayerId playerId, Card card) {
        this.mapped.putIfAbsent(playerId, card);
    }


}

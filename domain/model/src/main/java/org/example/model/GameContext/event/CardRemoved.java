package org.example.model.GameContext.event;

import org.example.model.GameContext.card.values.CardId;
import org.example.model.GameContext.round.values.RoundId;
import org.example.model.generic.DomainEvent;
import org.example.model.GameContext.player.values.PlayerId;

import java.util.Set;

public class CardRemoved extends DomainEvent {

    private final RoundId roundId;

    private final Set<PlayerId> losers;

    private final Set<CardId> cardId;

    public CardRemoved(PlayerId winner, Set<PlayerId> losers, Set<CardId> cardId) {
        super("cardgame.CardRemoved");
        this.winner = winner;
        this.losers = losers;
        this.cardId = cardId;
    }

    public PlayerId getWinner() { return winner; }


    public Set<PlayerId> getLosers() { return losers; }

    public CardId getCard() { return cardId; }
}

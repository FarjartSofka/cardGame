package org.example.model.GameContext.event;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.model.GameContext.card.CardFactory;
import org.example.model.GameContext.player.values.PlayerId;

public class AddedCardtoPlayer extends DomainEvent {

    private final PlayerId playerId;
    private final CardFactory deck;

    public AddedCardtoPlayer(PlayerId playerId, CardFactory deck) {
        super("cardgame.AddedCardtoPlayer");
        this.playerId = playerId;
        this.deck = deck;
    }

    public PlayerId getPlayerId() {
        return playerId;
    }

    public CardFactory getCardsOnDeck() {
        return deck;
    }
}

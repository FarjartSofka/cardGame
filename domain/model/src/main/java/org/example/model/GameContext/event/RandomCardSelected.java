package org.example.model.GameContext.event;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.model.GameContext.card.Card;


public class RandomCardSelected extends DomainEvent {

    private final Card cardId;

    public RandomCardSelected(Card cardId) {
        super("cardgame.RandomCardSelected");
        this.cardId = cardId;
    }

    public Card cardId() { return cardId; }
}

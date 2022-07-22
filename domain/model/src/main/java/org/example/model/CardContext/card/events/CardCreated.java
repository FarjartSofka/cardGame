package org.example.model.CardContext.card.events;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.model.CardContext.card.Card;

public class CardCreated extends DomainEvent {

    private final Card card;

    public CardCreated(Card card) {
        super("card.CardCreated");
        this.card = card;
    }

    public Card getCard() {
        return card;
    }
}

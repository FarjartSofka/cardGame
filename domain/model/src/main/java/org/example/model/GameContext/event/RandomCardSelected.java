package org.example.model.GameContext.event;

import co.com.sofka.domain.generic.DomainEvent;
import org.example.model.GameContext.deck.values.DeckId;

public class RandomCardSelected extends DomainEvent {

    private final DeckId cardId;

    public RandomCardSelected(DeckId cardId) {
        super("cardgame.RandomCardSelected");
        this.cardId = cardId;
    }

    public DeckId cardId() { return cardId; }
}

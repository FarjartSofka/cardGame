package org.example.model.GameContext.event;

import org.example.model.generic.DomainEvent;
import org.example.model.GameContext.card.PlayCard;


public class RandomCardSelected extends DomainEvent {

    private final PlayCard playCardId;

    public RandomCardSelected(PlayCard playCardId) {
        super("cardgame.RandomCardSelected");
        this.playCardId = playCardId;
    }

    public PlayCard cardId() { return playCardId; }
}

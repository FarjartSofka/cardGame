package org.example.model.GameContext.card;

import org.example.model.CardContext.card.Card;
import org.example.model.GameContext.card.values.CardId;
import org.example.model.GameContext.card.values.isHidden;
import org.example.model.GameContext.card.values.isLocked;
import org.example.model.generic.Entity;

public class PlayCard extends Entity<CardId> {

    private final isHidden hidden;

    private final isLocked lock;

    private final Card card;

    public PlayCard(CardId entityId, Card card) {
        super(entityId);
        this.card = card;
        this.hidden = new isHidden(true);
        this.lock = new isLocked(false);
    }

    public isHidden hidden() { return hidden; }

    public isLocked locked() { return lock; }

    public Card getCard() { return card; }
}

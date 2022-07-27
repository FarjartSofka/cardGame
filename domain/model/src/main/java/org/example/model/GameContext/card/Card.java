package org.example.model.GameContext.card;

import org.example.model.GameContext.card.values.CardId;
import org.example.model.GameContext.card.values.isHidden;
import org.example.model.GameContext.card.values.isLocked;
import org.example.model.generic.Entity;

public class Card extends Entity<CardId> {

    private final isHidden hidden;

    private final isLocked lock;

    public Card(CardId entityId) {
        super(entityId);
        this.hidden = new isHidden(true);
        this.lock = new isLocked(false);
    }

    public isHidden hidden() { return hidden; }

    public isLocked locked() { return lock; }
}

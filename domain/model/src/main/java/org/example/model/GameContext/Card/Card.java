package org.example.model.GameContext.Card;

import co.com.sofka.domain.generic.Entity;
import org.example.model.GameContext.Card.values.CardId;
import org.example.model.GameContext.Card.values.isHidden;
import org.example.model.GameContext.Card.values.isLocked;

public class Card extends Entity<CardId> {

    private final isHidden hidden;

    private final isLocked lock;

    public Card(CardId entityId, isHidden hidden, isLocked lock) {
        super(entityId);
        this.hidden = hidden;
        this.lock = lock;
    }

    public isHidden hidden() { return hidden; }

    public isLocked locked() { return lock; }
}

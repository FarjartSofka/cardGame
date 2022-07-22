package org.example.model.card;

import co.com.sofka.domain.generic.Entity;
import org.example.model.card.values.CardId;
import org.example.model.card.values.Power;
import org.example.model.card.values.Url;

public class Card extends Entity<CardId> {

    private final Url url;

    private final Power power;

    public Card(CardId entityId, Url url, Power power) {
        super(entityId);
        this.url = url;
        this.power = power;
    }

}


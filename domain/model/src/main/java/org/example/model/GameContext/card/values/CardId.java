package org.example.model.GameContext.card.values;

import co.com.sofka.domain.generic.Identity;

public class CardId extends Identity {

    private  CardId(String id){ super(id); }

    public CardId() {
    }

    public static CardId of(String id) { return new CardId(id); }
}

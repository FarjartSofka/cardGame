package org.example.model.CardContext.card.values;

import co.com.sofka.domain.generic.Identity;

public class CardId extends Identity {

    public CardId(String cardId) {
        super(cardId);
    }

    public CardId() {
    }

    public static CardId of(String cardId) {
        return new CardId(cardId);
    }

}

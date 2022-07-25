package org.example.model.GameContext.deck.values;

import co.com.sofka.domain.generic.Identity;

public class DeckId extends Identity {

    public DeckId(String deckId) { super(deckId); }

    public DeckId() {
    }

    public static DeckId of(String deckId) { return new DeckId(deckId); }

}

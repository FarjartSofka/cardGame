package org.example.model.deck;

import co.com.sofka.domain.generic.Entity;
import org.example.model.deck.values.DeckId;
import org.example.model.deck.values.Quantity;
import org.example.model.game.Game;
import org.example.model.player.Player;
import org.example.model.card.Card;

import java.util.Set;

public class Deck extends Entity<DeckId> {

    private final Set<Card> cards;

    private final Quantity quantity;

    public Deck(DeckId entityId, Set<Card> cards, Quantity quantity) {
        super(entityId);
        this.cards = cards;
        this.quantity = quantity;
    }
}

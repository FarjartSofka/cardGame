package org.example.model.GameContext.deck;

import org.example.model.GameContext.deck.values.DeckId;
import org.example.model.GameContext.deck.values.Quantity;
import org.example.model.GameContext.card.Card;
import org.example.model.generic.Entity;

import java.util.Set;

public class Deck extends Entity<DeckId> {

    private Set<Card> cards;

    private Quantity quantity;

    public Deck(DeckId entityId, Set<Card> cards, Quantity quantity) {
        super(entityId);
        this.cards = cards;
        this.quantity = quantity;
    }

    public void addCard(Card card){
        this.cards.add(card);
        this.quantity = new Quantity(cards.size());
        //this.quantity +=1;
    }

    public void removeCard(Card card){
        this.cards.remove(card);
        this.quantity = new Quantity(cards.size());
        //this.quantity -=1;
    }

    public Set<Card> cards() {
        return cards;
    }

    public Quantity quantity() {
        return quantity;
    }

}

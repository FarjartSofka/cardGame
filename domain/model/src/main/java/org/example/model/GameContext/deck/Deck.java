package org.example.model.GameContext.deck;

import org.example.model.GameContext.deck.values.DeckId;
import org.example.model.GameContext.deck.values.Quantity;
import org.example.model.GameContext.card.PlayCard;
import org.example.model.generic.Entity;

import java.util.Set;

public class Deck extends Entity<DeckId> {

    private Set<PlayCard> playCards;

    private Quantity quantity;

    public Deck(DeckId entityId, Set<PlayCard> playCards, Quantity quantity) {
        super(entityId);
        this.playCards = playCards;
        this.quantity = quantity;
    }

    public void addCard(PlayCard playCard){
        this.playCards.add(playCard);
        this.quantity = new Quantity(playCards.size());
        //this.quantity +=1;
    }

    public void removeCard(PlayCard playCard){
        this.playCards.remove(playCard);
        this.quantity = new Quantity(playCards.size());
        //this.quantity -=1;
    }

    public Set<PlayCard> cards() {
        return playCards;
    }

    public Quantity quantity() {
        return quantity;
    }

}

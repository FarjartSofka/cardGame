package org.example.model.deck;

import org.example.model.game.Game;
import org.example.model.player.Player;
import org.example.model.card.Card;

import java.util.Set;

public class Deck {

    private String id;

    private Player player;

    private Game game;

    private Set<Card> cards;

    public Deck() {
    }

    public Deck(String id, Player player, Game game, Set<Card> cards) {
        this.id = id;
        this.player = player;
        this.game = game;
        this.cards = cards;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Set<Card> getCards() {
        return cards;
    }

    public void setCards(Set<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Deck{" +
                "id='" + id + '\'' +
                ", player=" + player +
                ", game=" + game +
                ", cards=" + cards +
                '}';
    }
}

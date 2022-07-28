package org.example.model.GameContext.player;


import org.example.model.generic.Entity;
import org.example.model.GameContext.card.PlayCard;
import org.example.model.GameContext.deck.Deck;
import org.example.model.GameContext.player.values.Score;
import org.example.model.GameContext.player.values.Nickname;
import org.example.model.GameContext.player.values.PlayerId;

public class Player extends Entity<PlayerId> {


    private Nickname nickname;

    private Deck deck;

    private Score score;

    public Player(PlayerId entityId, Nickname nickname) {
        super(entityId);
        this.nickname = nickname;
    }


    public Score score() {
        return score;
    }

    public PlayerId userId() { return entityId; }

    public Deck gameCards() { return deck; }

    public void addCardtoPlayer(PlayCard playCard){
        this.deck.addCard(playCard);
    }

    public void removeCardtoPlayer(PlayCard playCard){
        this.deck.removeCard(playCard);
    }

    public void addPointsPlayer(){ this.score = new Score(score().value()+1); }

}

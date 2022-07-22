package org.example.model.player;


import co.com.sofka.domain.generic.Entity;
import org.example.model.player.values.Deck;
import org.example.model.player.values.Nickname;
import org.example.model.player.values.PlayerId;
import org.example.model.player.values.Score;

public class Player extends Entity<PlayerId> {


    private final Nickname nickname;

    private final Deck deck;

    private final Score score;

    public Player(PlayerId entityId, Nickname nickname, Deck deck, Score score) {
        super(entityId);
        this.nickname = nickname;
        this.deck = deck;
        this.score = score;
    }

}

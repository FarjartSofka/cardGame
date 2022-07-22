package org.example.model.GameContext.player;


import co.com.sofka.domain.generic.Entity;
import org.example.model.GameContext.player.values.Deck;
import org.example.model.GameContext.player.values.Score;
import org.example.model.GameContext.player.values.Nickname;
import org.example.model.GameContext.player.values.PlayerId;

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

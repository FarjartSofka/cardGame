package org.example.model.GameContext.player;


import co.com.sofka.domain.generic.Entity;
import org.example.model.CardContext.card.Card;
import org.example.model.GameContext.player.values.CardsOnDeck;
import org.example.model.GameContext.player.values.Score;
import org.example.model.GameContext.player.values.Nickname;
import org.example.model.GameContext.player.values.PlayerId;

import java.util.Objects;
import java.util.Set;

public class Player extends Entity<PlayerId> {


    private Nickname nickname;

    private Set<CardsOnDeck> deck;

    private Score score;

    public Player(PlayerId entityId, Nickname nickname, Set<CardsOnDeck> deck, Score score) {
        super(entityId);
        this.nickname = nickname;
        this.deck = deck;
        this.score = score;
    }

    public Score score() {
        return score;
    }

    public PlayerId userId() { return entityId; }

    public Set<CardsOnDeck> gameCards() { return deck; }

    public void updateScore(Score score) {
        Integer value = Objects.requireNonNull(score.value());
        this.score = new Score(value);
    }

    public void addCard(CardsOnDeck card) {
        this.deck.add(Objects.requireNonNull(card));
    }


    public void removeCard(CardsOnDeck card) {
        String cardId = Objects.requireNonNull(card.value().cardId());
        this.deck.removeIf(
                gc -> Objects.equals(
                        gc.value().cardId(),
                        cardId
                )
        );

    }

}

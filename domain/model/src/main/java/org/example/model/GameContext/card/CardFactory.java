package org.example.model.GameContext.card;

import org.example.model.GameContext.player.values.PlayerId;

import java.util.*;

public class CardFactory {

    private final Map<PlayerId, Set<PlayCard>> cardsByPlayer;
    private static CardFactory instance;

    private CardFactory() {
        cardsByPlayer = new HashMap<>();
    }

    public static CardFactory getInstance() {
        if (Objects.isNull(instance)) {
            instance = new CardFactory();
            return instance;
        }
        return instance;
    }

    public CardFactory add(PlayerId playerId, Set<PlayCard> gamePlayCards) {
        cardsByPlayer.put(playerId, gamePlayCards);
        return this;
    }

    public Map<PlayerId, Set<PlayCard>> cardsByPlayer() {
        return cardsByPlayer;
    }
}
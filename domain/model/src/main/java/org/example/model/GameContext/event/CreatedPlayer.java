package org.example.model.GameContext.event;

import org.example.model.generic.DomainEvent;

public class CreatedPlayer extends DomainEvent {

    private final String playerId;

    private final String nickname;

    public CreatedPlayer(String playerId, String nickname) {
        super("cardgame.CreatedPlayer");
        this.playerId = playerId;
        this.nickname = nickname;
    }

    public String getPlayerId() { return playerId; }

    public String getNickname() { return nickname; }
}

package org.example.model.GameContext.event;

import org.example.model.generic.DomainEvent;
import org.example.model.GameContext.player.values.PlayerId;

public class AddedPlayer extends DomainEvent {
    private final PlayerId identity;
    private final String userId;

    public AddedPlayer(PlayerId identity, String userId) {
        super("cardgame.AddedPlayer");
        this.identity = identity;
        this.userId = userId;
    }

    public PlayerId getIdentity() {
        return identity;
    }

    public String getUserId() {
        return userId;
    }
}

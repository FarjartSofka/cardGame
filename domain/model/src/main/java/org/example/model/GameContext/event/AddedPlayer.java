package org.example.model.GameContext.event;

import org.example.model.GameContext.player.values.Nickname;
import org.example.model.generic.DomainEvent;
import org.example.model.GameContext.player.values.PlayerId;

public class AddedPlayer extends DomainEvent {

    public static final String EVENT_TYPE = "cardgame.AddedPlayer";
    private final PlayerId identity;
    private final Nickname nickname;

    public AddedPlayer(PlayerId identity, Nickname nickname) {
        super(EVENT_TYPE);
        this.identity = identity;
        this.nickname = nickname;
    }

    public PlayerId getIdentity() {
        return identity;
    }

    public Nickname getNickname() {
        return nickname;
    }
}

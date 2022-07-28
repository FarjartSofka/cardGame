package org.example.model.GameContext.event;

import org.example.model.GameContext.game.values.GameId;
import org.example.model.GameContext.player.Player;
import org.example.model.generic.DomainEvent;

public class GameFinished extends DomainEvent {

    private final GameId gameId;

    private final Player player;

    public GameFinished(GameId gameId, Player player) {
        super("cardgame.GameFinished");
        this.gameId = gameId;
        this.player = player;
    }

    public GameId getGameId() { return gameId; }

    public Player getPlayer() { return player; }
}

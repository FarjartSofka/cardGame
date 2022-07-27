package org.example.model.GameContext.command;

import org.example.model.GameContext.game.values.GameId;
import org.example.model.GameContext.player.values.PlayerId;
import org.example.model.generic.Command;

public class CreatePlayerCommand extends Command {

    private GameId gameId;

    private PlayerId playerId;

    public CreatePlayerCommand() {
    }

    public CreatePlayerCommand(GameId gameId, PlayerId playerId) {
        this.gameId = gameId;
        this.playerId = playerId;
    }

    public PlayerId getPlayerId() { return playerId; }

    public void setPlayerId(PlayerId playerId) {
        this.playerId = playerId;
    }

    public GameId getGameId() { return gameId; }

    public void setGameId(GameId gameId) { this.gameId = gameId; }
}

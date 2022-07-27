package org.example.model.GameContext.command;

import org.example.model.GameContext.game.values.GameId;
import org.example.model.generic.Command;

public class StartGameCommand extends Command {

    private final GameId gameId;

    public StartGameCommand(GameId gameId) { this.gameId = gameId; }

    public GameId getGameId() { return gameId; }
}

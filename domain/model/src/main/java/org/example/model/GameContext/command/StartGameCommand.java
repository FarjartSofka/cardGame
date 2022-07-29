package org.example.model.GameContext.command;

import org.example.model.GameContext.game.values.GameId;
import org.example.model.generic.Command;

public class StartGameCommand extends Command {

    private String gameId;

    public StartGameCommand(String gameId) { this.gameId = gameId; }

    public StartGameCommand() {
    }

    public String getGameId() { return gameId; }
}

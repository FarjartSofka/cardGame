package org.example.model.GameContext.command;

import co.com.sofka.domain.generic.Command;

public class StartGameCommand extends Command {

    private final String gameId;

    public StartGameCommand(String gameId) { this.gameId = gameId; }

    public String getGameId() { return gameId; }
}

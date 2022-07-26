package org.example.model.GameContext.command;

import co.com.sofka.domain.generic.Command;
import org.example.model.GameContext.game.values.GameId;

public class StartGameCommand extends Command {

    private final GameId gameId;

    public StartGameCommand(GameId gameId) { this.gameId = gameId; }

    public GameId getGameId() { return gameId; }
}

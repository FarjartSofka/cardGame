package org.example.model.GameContext.command;

import org.example.model.generic.Command;

import java.util.Map;
import java.util.Set;

public class CreateGameCommand extends Command {

    private String gameId;

    private Map<String, String> playersId;

    public CreateGameCommand() {
    }

    public CreateGameCommand(String gameId, Map<String, String> playersId) {
        this.gameId = gameId;
        this.playersId = playersId;
    }

    public String getGameId() { return gameId; }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public Map<String, String> getPlayersId() {
        return playersId;
    }

    public void setPlayersId(Map<String, String> playersId) {
        this.playersId = playersId;
    }
}

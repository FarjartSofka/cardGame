package org.example.model.GameContext.command;

import co.com.sofka.domain.generic.Command;
import org.example.model.GameContext.player.Player;

import java.util.Set;

public class CreateGameCommand extends Command {

    private String gameId;

    private Set<Player> playersId;

    public CreateGameCommand() {
    }

    public CreateGameCommand(String gameId, Set<Player> playersId) {
        this.gameId = gameId;
        this.playersId = playersId;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public Set<Player> getPlayersId() {
        return playersId;
    }

    public void setPlayersId(Set<Player> playersId) {
        this.playersId = playersId;
    }
}

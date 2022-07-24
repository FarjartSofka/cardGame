package org.example.model.GameContext.command;

import co.com.sofka.domain.generic.Command;
import org.example.model.GameContext.game.values.GameId;
import org.example.model.GameContext.player.values.PlayerId;

public class CreatePlayerCommand extends Command {

    private PlayerId playerId;

    public CreatePlayerCommand() {
    }

    public CreatePlayerCommand(PlayerId playerId) {
        this.playerId = playerId;
    }

    public PlayerId getPlayerId() { return playerId; }

    public void setPlayerId(PlayerId playerId) {
        this.playerId = playerId;
    }
}

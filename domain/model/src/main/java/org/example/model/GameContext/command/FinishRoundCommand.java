package org.example.model.GameContext.command;

import org.example.model.generic.Command;

public class FinishRoundCommand extends Command {

    private String gameId;

    private String roundId;

    public FinishRoundCommand() {
    }

    public FinishRoundCommand(String gameId, String roundId) {
        this.gameId = gameId;
        this.roundId = roundId;
    }

    public String getGameId() {
        return gameId;
    }

    public String getRoundId() {
        return roundId;
    }

}

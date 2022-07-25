package org.example.model.GameContext.command;

import co.com.sofka.domain.generic.Command;

public class PlayCardCommand extends Command {

    private String gameId;

    private String playerId;

    private String cardId;

    public PlayCardCommand() {
    }

    public PlayCardCommand(String gameId, String playerId, String cardId) {
        this.gameId = gameId;
        this.playerId = playerId;
        this.cardId = cardId;
    }

    public String getGameId() { return gameId; }

    public String getPlayerId() { return playerId; }

    public String getCardId() { return cardId; }

}

package org.example.model.GameContext.command;

import org.example.model.GameContext.card.values.CardId;
import org.example.model.GameContext.game.values.GameId;
import org.example.model.GameContext.player.values.PlayerId;
import org.example.model.GameContext.round.values.RoundId;
import org.example.model.generic.Command;

public class DealCardCommand extends Command {

    private GameId gameId;

    private PlayerId playerId;

    private CardId cardId;

    public DealCardCommand() {
    }

    public DealCardCommand(GameId gameId, PlayerId playerId, CardId cardId) {
        this.gameId = gameId;
        this.playerId = playerId;
        this.cardId = cardId;
    }

    public GameId getGameId() { return gameId; }

    public PlayerId getPlayerId() { return playerId; }

    public CardId getCardId() { return cardId; }
}

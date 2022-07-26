package org.example.model.GameContext.command;

import co.com.sofka.domain.generic.Command;
import org.example.model.GameContext.card.values.CardId;
import org.example.model.GameContext.game.values.GameId;
import org.example.model.GameContext.player.values.PlayerId;
import org.example.model.GameContext.round.values.RoundId;

public class PlayCardCommand extends Command {

    private GameId gameId;

    private PlayerId playerId;

    private RoundId roundId;

    private CardId cardId;

    public PlayCardCommand() {
    }

    public PlayCardCommand(GameId gameId, PlayerId playerId, RoundId roundId, CardId cardId) {
        this.gameId = gameId;
        this.playerId = playerId;
        this.roundId = roundId;
        this.cardId = cardId;
    }

    public GameId getGameId() { return gameId; }

    public PlayerId getPlayerId() { return playerId; }

    public RoundId getRoundId() { return roundId; }

    public CardId getCardId() { return cardId; }
}

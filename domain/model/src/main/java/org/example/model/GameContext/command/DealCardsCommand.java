package org.example.model.GameContext.command;

import co.com.sofka.domain.generic.Command;
import org.example.model.GameContext.card.Card;
import org.example.model.GameContext.game.values.GameId;
import org.example.model.GameContext.player.values.PlayerId;

import java.util.Set;

public class DealCardsCommand extends Command {

    private final GameId gameId;

    private final PlayerId playerId;

    private final Set<Card> cards;

    public DealCardsCommand(GameId gameId, PlayerId playerId, Set<Card> cards) {
        this.gameId = gameId;
        this.playerId = playerId;
        this.cards = cards;
    }

    public GameId getGameId() {
        return gameId;
    }

    public PlayerId getPlayerId() {
        return playerId;
    }

    public Set<Card> getCards() {
        return cards;
    }
}


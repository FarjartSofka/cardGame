package org.example.model.GameContext.command;

import co.com.sofka.domain.generic.Command;
import org.example.model.GameContext.card.Card;

import java.util.Set;

public class DealCardsCommand extends Command {

    private String gameId;

    private String playerId;

    private Set<Card> cards;

    public DealCardsCommand(String gameId, String playerId, Set<Card> cards) {
        this.gameId = gameId;
        this.playerId = playerId;
        this.cards = cards;
    }

    public DealCardsCommand() {
    }

    public String getGameId() {
        return gameId;
    }

    public String getPlayerId() {
        return playerId;
    }

    public Set<Card> getCards() {
        return cards;
    }
}


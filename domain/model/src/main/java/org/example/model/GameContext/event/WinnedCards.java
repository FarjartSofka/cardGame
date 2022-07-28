package org.example.model.GameContext.event;

import org.example.model.GameContext.card.PlayCard;
import org.example.model.GameContext.game.values.GameId;
import org.example.model.GameContext.player.values.PlayerId;
import org.example.model.GameContext.round.values.RoundId;
import org.example.model.generic.DomainEvent;

import java.util.Set;

public class WinnedCards extends DomainEvent {

    private final GameId gameId;

    private final PlayerId playerId;

    private final RoundId roundId;

    private final Set<PlayCard> playCards;

    public WinnedCards(GameId gameId, PlayerId playerId, RoundId roundId, Set<PlayCard> playCards) {
        super("cardgame.WinnedCards");
        this.gameId = gameId;
        this.playerId = playerId;
        this.roundId = roundId;
        this.playCards = playCards;
    }

    public GameId getGameId() { return gameId; }

    public PlayerId getPlayerId() { return playerId;   }

    public RoundId getRoundId() { return roundId; }

    public Set<PlayCard> getCards() { return playCards; }
}

package org.example.model.GameContext.event;


import org.example.model.GameContext.card.PlayCard;
import org.example.model.GameContext.player.values.PlayerId;
import org.example.model.GameContext.round.Round;
import org.example.model.generic.DomainEvent;

public class AddedCardtoBoard extends DomainEvent {

    public static final String EVENT_TYPE = "cardGame.AddedCardtoBoard";

    private final PlayerId playerId;

    private final PlayCard cards;

    private final Round round;

    public AddedCardtoBoard(PlayerId playerId, PlayCard cards, Round round) {
        super(EVENT_TYPE);
        this.playerId = playerId;
        this.cards = cards;
        this.round = round;
    }

    public PlayerId getPlayerId() { return playerId; }

    public PlayCard getCards() { return cards; }

    public Round getRound() { return round; }
}

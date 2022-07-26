package org.example.model.GameContext.game;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import org.example.model.GameContext.board.Board;
import org.example.model.GameContext.board.values.BoardId;
import org.example.model.GameContext.card.Card;
import org.example.model.GameContext.card.CardFactory;
import org.example.model.GameContext.event.*;
import org.example.model.GameContext.game.values.GameId;
import org.example.model.GameContext.game.values.Round;
import org.example.model.GameContext.player.Player;
import org.example.model.GameContext.player.values.Nickname;

import org.example.model.GameContext.player.values.PlayerId;

import java.util.*;

public class Game extends AggregateEvent<GameId> {

    protected Board board;

    protected Set<Player> players;

    protected Set<Round> round;

    protected Player winner;

    public Game(GameId gameId, Set<Player> player){
        super(gameId);
        subscribe( new GameEventChange(this));
        appendChange( new CreatedGame()).apply();
        player.forEach(user -> appendChange(new AddedPlayer(user.identity(), user.userId().toString())).apply()
        );
        appendChange(new CreatedBoard(new BoardId())).apply();
    }






    public Game(GameId entityId) {
        super(entityId);
        subscribe(new GameEventChange(this));
        appendChange( new CreatedGame()).apply();
    }

    public static Game from(GameId gameId, List<DomainEvent> events) {
        var game = new Game(gameId);
        events.forEach(game::applyEvent);
        return game;
    }

    public void startGame(GameId gameId,Map<PlayerId, Set<Card>> deck) {
        deck
                .forEach((playerId, deckSet) ->
                        appendChange(new DistributedCards(gameId, playerId, deckSet)).apply()
                );
    }

    public void addCardToBoard(PlayerId playerId, CardFactory cards) {
        appendChange(new AddedCardtoPlayer(playerId, cards)).apply();
    }

    public void addPlayer(PlayerId playerId, Nickname nickname){
        appendChange(new CreatedPlayer(playerId.value(), nickname.value() )).apply();
    }


    public Optional<Player> getPlayer(PlayerId playerId) {
        return this.players.stream()
                .filter(player ->
                        Objects.equals(player.identity(), playerId))
                .findFirst();
    }


}

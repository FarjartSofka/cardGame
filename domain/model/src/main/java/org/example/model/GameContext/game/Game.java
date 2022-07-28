package org.example.model.GameContext.game;

import org.example.model.GameContext.card.PlayCard;
import org.example.model.GameContext.game.values.GameState;
import org.example.model.GameContext.round.Round;
import org.example.model.GameContext.round.values.RoundId;
import org.example.model.GameContext.round.values.RoundNumber;
import org.example.model.generic.AggregateEvent;
import org.example.model.GameContext.board.Board;
import org.example.model.GameContext.board.values.BoardId;
import org.example.model.GameContext.card.CardFactory;
import org.example.model.GameContext.event.*;
import org.example.model.GameContext.game.values.GameId;
import org.example.model.GameContext.player.Player;
import org.example.model.GameContext.player.values.Nickname;

import org.example.model.GameContext.player.values.PlayerId;
import org.example.model.generic.DomainEvent;

import java.sql.Array;
import java.util.*;

public class Game extends AggregateEvent<GameId> {

    protected Board board;

    protected Set<Player> players;

    protected Set<Round> round;

    protected PlayCard card;

    protected Player winner;

    protected GameState state;

    public Game(GameId gameId, Set<Player> player){
        super(gameId);
        subscribe( new GameEventChange(this));
        appendChange( new CreatedGame()).apply();
        player.forEach(user -> appendChange(new AddedPlayer(user.identity(), user.getNickname())).apply()
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

    public void startGame(GameId gameId) {
        appendChange(new StartedGame(gameId)).apply();
    }

    public void finishGame(Player winner) {
        appendChange(new GameFinished(this.entityId, winner)).apply();
    }

    public void distributeCards(CardFactory cardsFactory) {
        cardsFactory.cardsByPlayer()
                .forEach((playerId, gameCards) ->
                        appendChange(new DistributedCards(playerId, gameCards, round())).apply()
                );
    }

    public void addCardToBoard(PlayerId playerId, PlayCard card) {
        appendChange(new AddedCardtoBoard(playerId, card, round())).apply();
    }

    public void createRound(RoundId roundId) {
        appendChange(new CreatedRound( roundId, this.entityId, new RoundNumber(round.size() + 1))).apply();
    }

    public void assignRoundPlayers(RoundId roundId) {
        appendChange(new PlayedRound(roundId, getPlayersInGame())).apply();
    }

    private Set<PlayerId> getPlayersInGame(){
        HashSet<PlayerId> listPlayer = new HashSet<>();
        players.forEach(player -> {
            if(player.gameCards().size() !=0)
                listPlayer.add(player.identity());
        }
            );
        return listPlayer;
    }

    public Optional<Player> getPlayer(PlayerId playerId) {
        return this.players.stream()
                .filter(player ->
                        Objects.equals(player.identity(), playerId))
                .findFirst();
    }

    public Set<Player> getPlayers() { return players; }

    public GameState getState() { return state; }

    public Round round() {
        return this.round.stream()
                .min(Comparator.comparing(Round::getNumber))
                .orElseThrow(() -> new IllegalArgumentException("No existe la ronda"));
    }


}

package org.example.model.GameContext.game;

import org.example.model.GameContext.card.values.CardId;
import org.example.model.GameContext.game.values.GameState;
import org.example.model.generic.EventChange;
import org.example.model.GameContext.deck.Deck;
import org.example.model.GameContext.deck.values.DeckId;
import org.example.model.GameContext.event.*;

import org.example.model.GameContext.command.CreateGameCommand;
import org.example.model.GameContext.event.CreatedGame;
import org.example.model.GameContext.event.CreatedPlayer;
import org.example.model.GameContext.player.Player;
import org.example.model.GameContext.player.values.Nickname;
import org.example.model.GameContext.player.values.PlayerId;

import java.util.HashSet;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameEventChange extends EventChange {


    public GameEventChange(Game game) {

        apply((CreatedGame event)-> {
            game.players = new HashSet<>();
            game.state = new GameState(GameState.States.CREATED);
        });

        apply((StartedGame event)-> {
            game.state = new GameState(GameState.States.IN_GAME);
        });

        apply((CreatedPlayer event)->{
            var playerId = PlayerId.of(event.getPlayerId());
            var nickname = new Nickname(event.getNickname());
            game.players.add(new Player(playerId,nickname));
        });

        apply((CardPlayed event)->{
            var player = game.getPlayer(PlayerId.of(event.getPlayerId()));
            var carta = player.get()
                    .gameCards()
                    .cards()
                    .stream()
                    .filter(card -> card.identity().value().equals(event.getCardId()))
                    .findFirst()
                    .orElseThrow();
        });

        apply((DistributedCards event) -> {
            game.players.stream()
                    .filter(player ->
                            Objects.equals(player.identity(), event.getPlayerId()))
                    .findFirst()
                    .ifPresent(player ->
                            event.getGameCards().forEach(player::addCardtoPlayer)
                    );
        });

        apply((CardRemoved event)->{
            var player = game.getPlayers()
                    .stream()
                    ;

        });


    }

}

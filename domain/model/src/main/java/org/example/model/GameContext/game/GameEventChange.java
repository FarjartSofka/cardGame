package org.example.model.GameContext.game;

import org.example.model.GameContext.game.values.GameState;
import org.example.model.generic.EventChange;
import org.example.model.GameContext.event.*;

import org.example.model.GameContext.event.CreatedGame;
import org.example.model.GameContext.player.Player;
import org.example.model.GameContext.player.values.Nickname;
import org.example.model.GameContext.player.values.PlayerId;

import java.util.HashSet;
import java.util.Objects;

public class GameEventChange extends EventChange {


    public GameEventChange(Game game) {

        apply((CreatedGame event)-> {
            game.players = new HashSet<>();
            game.state = new GameState(GameState.States.CREATED);
        });

        apply((StartedGame event)-> {
            game.state = new GameState(GameState.States.IN_GAME);
        });

        apply((AddedPlayer event)->{
            var playerId = event.getIdentity();
            var nickname = event.getNickname();
            game.players.add(new Player(playerId,nickname));
        });

        apply((CardPlayed event)->{
            var player = game.getPlayer(PlayerId.of(event.getPlayerId()));
            var carta = player.get()
                    .gameCards()
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

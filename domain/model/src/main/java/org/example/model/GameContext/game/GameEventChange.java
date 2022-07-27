package org.example.model.GameContext.game;

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
import java.util.stream.Collectors;

public class GameEventChange extends EventChange {


    public GameEventChange(Game game) {

        apply((CreatedGame event)-> {
            game.players = new HashSet<>();
            game.round = new HashSet<>();
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

        apply((AddedCardtoPlayer event)->{
            var player = game.getPlayer(event.getPlayerId());
            event.getCardsOnDeck()
                    .cards()
                    .stream()
                    .forEach(card -> player.get().addCardtoPlayer(card));
        });

        apply((CardRemoved event)->{
            var player = game.getPlayer(event.getPlayerId());
            player.get().removeCardtoPlayer(event.getCard());
        });


    }

}

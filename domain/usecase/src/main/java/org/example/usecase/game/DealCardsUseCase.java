package org.example.usecase.game;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.infraestructure.repository.EventStoreRepository;
import org.example.model.CardContext.card.Card;
import org.example.model.CardContext.card.gateway.CardRepository;
import org.example.model.GameContext.card.CardFactory;
import org.example.model.GameContext.command.DealCardsCommand;
import org.example.model.GameContext.game.Game;
import org.example.model.GameContext.game.values.GameId;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class DealCardsUseCase extends UseCase<RequestCommand<DealCardsCommand>, ResponseEvents> {

    private List<Card> listaDeCartas = new ArrayList<>();

    private final CardRepository cardRepository;

    private final EventStoreRepository repository;

    public DealCardsUseCase(CardRepository cardRepository, EventStoreRepository repository) {
        this.cardRepository = cardRepository;
        this.repository = repository;
    }

    @Override
    public void executeUseCase(RequestCommand<DealCardsCommand> requestCommand) {
        var command = requestCommand.getCommand();
        var gameId = GameId.of(command.getGameId().toString());
        var events =  repository().getEventsBy("cardgame", gameId.toString());
        var game = Game.from(gameId, events);

        var cardFactory = new CardFactory();

        var card = cardRepository.findAll().collectList().block();
        Collections.shuffle(card);

        card.stream()
                .forEach(cardtoDeck -> cardFactory.add(new Card(cardtoDeck.getId(),car));
    }
}

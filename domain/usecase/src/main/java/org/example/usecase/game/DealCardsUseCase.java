package org.example.usecase.game;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.infraestructure.repository.EventStoreRepository;
import org.example.model.GameContext.card.Card;
import org.example.model.CardContext.card.gateway.CardRepository;
import org.example.model.GameContext.card.CardFactory;
import org.example.model.GameContext.card.values.CardId;
import org.example.model.GameContext.command.DealCardsCommand;
import org.example.model.GameContext.deck.Deck;
import org.example.model.GameContext.game.Game;
import org.example.model.GameContext.game.values.GameId;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;


public class DealCardsUseCase extends UseCase<RequestCommand<DealCardsCommand>, ResponseEvents> {

    private List<Card> cardList = new ArrayList<>();

    private Deck deck;
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
                .forEach(cardtoDeck -> cardFactory.add(new Card(CardId.of(cardtoDeck.getId()))));

        cardFactory.cards().forEach(cardx -> deck.addCard(cardx));

        cardList = new ArrayList<>(new HashSet<>(game.getDeck().cards()));

        game.getPlayers().forEach(player -> {
            Collections.shuffle(cardList);
            var factory = new CardFactory();
            cardList.stream().limit(5).forEach(factory::add);
            game.addCardToBoard(player.userId(), factory);
        });

    }
}

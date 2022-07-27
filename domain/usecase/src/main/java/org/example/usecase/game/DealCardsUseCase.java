package org.example.usecase.game;

import org.example.model.GameContext.card.Card;
import org.example.model.CardContext.card.gateway.CardRepository;
import org.example.model.GameContext.card.CardFactory;
import org.example.model.GameContext.card.values.CardId;
import org.example.model.GameContext.command.DealCardsCommand;
import org.example.model.GameContext.deck.Deck;
import org.example.model.GameContext.game.Game;
import org.example.model.GameContext.game.values.GameId;

import org.example.model.generic.DomainEvent;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.function.Function;


public class DealCardsUseCase implements Function<DealCardsCommand, Flux<DomainEvent>> {

    private List<Card> cardList = new ArrayList<>();

    private Deck deck;
    private final CardRepository cardRepository;

    public DealCardsUseCase(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Flux<DomainEvent> apply(DealCardsCommand requestCommand) {

        var gameId = GameId.of(requestCommand.getGameId().toString());
        var game = Game.from(gameId);

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
        game.getUncommittedChanges();
        return Flux.fromIterable(game.getUncommittedChanges());
    }
}

package org.example.usecase.game;

import org.example.model.CardContext.card.Card;
import org.example.model.CardContext.card.gateway.CardRepository;
import org.example.model.GameContext.card.PlayCard;
import org.example.model.GameContext.card.CardFactory;
import org.example.model.GameContext.card.values.CardId;
import org.example.model.GameContext.event.DistributedCards;
import org.example.model.GameContext.game.Game;
import org.example.model.generic.DomainEvent;
import org.example.model.generic.EventStoreRepository;
import reactor.core.publisher.Flux;

import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DistributeCardsUseCase implements Function<DistributedCards, Flux<DomainEvent>> {
    private final EventStoreRepository repository;
    private final CardRepository cardRepository;

    public DistributeCardsUseCase(EventStoreRepository repository, CardRepository cardRepository) {
        this.repository = repository;
        this.cardRepository = cardRepository;
    }

    @Override
    public Flux<DomainEvent> apply(DistributedCards event) {
        return this.cardRepository.findAll()
                .collectList()
                .zipWith(this.repository.getEventsBy("game", event.getGameId().value()).collectList())
                .flatMapMany(objects -> {
                    var cards = objects.getT1();
                    var events = objects.getT2();
                    var game = Game.from(event.getGameId(), events);
                    return Flux.fromIterable(game.getPlayers())
                            .map(player -> CardFactory.getInstance().add(
                                            player.identity(),
                                            generateCards(cards)
                                    )
                            )
                            .last()
                            .map(factories -> {
                                game.distributeCards(factories);
                                return game.getUncommittedChanges();
                            })
                            .flatMapIterable(events1 -> events1);
                });
    }
    private Set<PlayCard> generateCards(List<Card> cards) {
        Collections.shuffle(cards);
        return Flux.fromIterable(cards)
                .take(5)
                .map(card -> new PlayCard(CardId.of(card.getId()), card))
                .collect(Collectors.toSet())
                .block();
    }
}

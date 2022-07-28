package org.example.usecase.game;

import org.example.model.CardContext.card.gateway.CardRepository;
import org.example.model.GameContext.card.PlayCard;
import org.example.model.GameContext.card.values.CardId;
import org.example.model.GameContext.command.AddCardToBoardCommand;
import org.example.model.GameContext.game.Game;
import org.example.model.GameContext.game.values.GameId;
import org.example.model.GameContext.player.values.PlayerId;
import org.example.model.generic.DomainEvent;
import org.example.model.generic.EventStoreRepository;
import reactor.core.publisher.Flux;

import java.util.function.Function;

public class AddCardToBoardUseCase implements Function<AddCardToBoardCommand, Flux<DomainEvent> {

    private final EventStoreRepository eventStoreRepository;

    private final CardRepository cardRepository;

    public AddCardToBoardUseCase(EventStoreRepository eventStoreRepository, CardRepository cardRepository) {
        this.eventStoreRepository = eventStoreRepository;
        this.cardRepository = cardRepository;
    }

    @Override
    public Flux<DomainEvent> apply(AddCardToBoardCommand command) {
        return this.eventStoreRepository.getEventsBy("game", command.getGameId().toString()).collectList()
                .zipWith(this.cardRepository.findById(command.getCardId().toString()))
                .flatMapIterable((objects) -> {
                    var events = objects.getT1();
                    var card = objects.getT2();
                    var game = Game.from(GameId.of(command.getGameId().toString()), events);

                    game.addCardToBoard(PlayerId.of(command.getPlayerId().toString()), new PlayCard(CardId.of(card.getId()), card));
                    return game.getUncommittedChanges();
                });
    }

}

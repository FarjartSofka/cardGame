package org.example.bus.config;

import org.example.model.GameContext.event.DistributedCards;
import org.example.model.GameContext.event.StartedGame;
import org.example.usecase.game.DistributeCardsUseCase;
import org.example.usecase.generic.UseCaseWrap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class EventListenerConfig {

    @Bean
    public Set<UseCaseWrap> useCaseWraps(
            DistributeCardsUseCase distributeCardsUseCase
    ){
        return Set.of(

                new UseCaseWrap(distributeCardsUseCase, StartedGame.EVENT_TYPE)
        );
    }

}

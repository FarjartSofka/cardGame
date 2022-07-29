package org.example.bus.config;

import org.example.model.GameContext.event.StartedGame;

import org.example.usecase.game.DistributeCardsUseCase;
import org.example.usecase.generic.UseCaseWrap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Set;

@Configuration
public class EventListenerConfig {

    private static final Logger logger = LoggerFactory.getLogger(EventListenerConfig.class);

    @Bean
    public Set<UseCaseWrap> useCaseWraps(
            DistributeCardsUseCase distributeCardsUseCase
    ){
        logger.info("Llego este evento: {}", StartedGame.EVENT_TYPE);
        return Set.of(
                new UseCaseWrap(distributeCardsUseCase, StartedGame.EVENT_TYPE)
        );
    }

}

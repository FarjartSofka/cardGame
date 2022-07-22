package org.example.model.GameContext.game.gateway;

import org.example.model.GameContext.game.Game;
import reactor.core.publisher.Mono;

public interface GameRepository {

    Mono<Game> save(Game game);
    Mono<Game> findById(String id);

}

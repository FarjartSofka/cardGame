package org.example.model.game.gateway;

import org.example.model.game.Game;
import reactor.core.publisher.Mono;

public interface GameRepository {

    Mono<Game> save(Game game);
    Mono<Game> findById(String id);

}

package org.example.model.gateway;

import org.example.model.Game;
import reactor.core.publisher.Mono;

public interface GameRepository {

    Mono<Game> save(Game game);
    Mono<Game> findById(String id);

}

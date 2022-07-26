package org.example.api.controller;

import org.example.api.handler.CardHandler;
import org.example.api.handler.GameHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;



import static org.springframework.web.reactive.function.server.RequestPredicates.*;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GameController {

    @Bean
    public RouterFunction<ServerResponse> routerGameFunction(GameHandler handler) {
        return RouterFunctions.nest(path("game"),route(POST("/create"), handler::save)) ;
    }
}

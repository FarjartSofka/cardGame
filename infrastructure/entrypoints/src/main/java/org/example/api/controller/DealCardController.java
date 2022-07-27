package org.example.api.controller;

import org.example.api.handler.DealCardHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DealCardController {

    @Bean
    public RouterFunction<ServerResponse> routerDealCardsFunction(DealCardHandler handler) {
        return RouterFunctions.nest(path("game"),route(GET("/deal"), handler::dealCards)) ;
    }

}

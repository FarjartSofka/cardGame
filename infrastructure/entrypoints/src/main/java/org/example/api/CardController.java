package org.example.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class CardController {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(CardHandler handler) {
        return  route(POST("/card/create"), handler::save)
                .andRoute(GET("/card/all"), handler::findAll )
                .andRoute(GET("/card/{id}"), handler::findById);
    }
}

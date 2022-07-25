package org.example.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class CardController {

    @Bean
    public RouterFunction<ServerResponse> routerFunction(CardHandler handler) {
        return RouterFunctions.nest(path("card"),route(POST("/create"), handler::save)
                .andRoute(POST("/save-all"), handler::saveAll)
                .andRoute(GET("/all"), handler::findAll )
                .andRoute(GET("/{id}"), handler::findById)) ;
    }
}

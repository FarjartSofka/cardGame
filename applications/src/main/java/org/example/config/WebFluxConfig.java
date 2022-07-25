package org.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.config.WebFluxConfigurer;
import org.springframework.web.reactive.config.WebFluxConfigurerComposite;

@Configuration
@EnableWebFlux
public class WebFluxConfig implements WebFluxConfigurer {

    @Bean
    public  WebFluxConfigurer corsConfigure() {
        return new WebFluxConfigurerComposite(){
            public void addCorsMapping(CorsRegistry registry){
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("*");
            }
        };
    }
}

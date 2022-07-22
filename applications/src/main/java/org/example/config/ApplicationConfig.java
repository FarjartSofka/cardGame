package org.example.config;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.infraestructure.asyn.SubscriberEvent;
import co.com.sofka.infraestructure.bus.EventBus;
import co.com.sofka.infraestructure.repository.EventStoreRepository;
import org.reactivecommons.utils.ObjectMapperI;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.autoconfigure.mongo.MongoClientSettingsBuilderCustomizer;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.boot.autoconfigure.mongo.MongoPropertiesClientSettingsBuilderCustomizer;
import org.springframework.boot.autoconfigure.mongo.ReactiveMongoClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.env.Environment;

import java.util.ArrayList;
import java.util.List;

@Configuration
@ComponentScan(basePackages = {"org.example.cardGame.usecase", "org.example.cardGame.model", "org.example.cardGame.adapters",
        "org.example.cardGame.controller", "org.example.cardGame.handler", "org.example.cardGame.event"},
        includeFilters = {
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+UseCase$"),
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+Repository$"),
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+Adapter$"),
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+Controller$"),
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+Handler$"),
                @ComponentScan.Filter(type = FilterType.REGEX, pattern = "^.+Event$"),
        },
        useDefaultFilters = false)
public class ApplicationConfig {

    public static final String EXCHANGE = "cardGame";

    @Bean
    public MongoDBSecret dbSecret(Environment env) {
        return new MongoDBSecret(env.getProperty("spring.data.mongodb.uri"));
    }

    @Bean
    public ReactiveMongoClientFactory mongoProperties(MongoDBSecret secret, Environment env) {
        MongoProperties properties = new MongoProperties();
        properties.setUri(secret.getUri());

        List<MongoClientSettingsBuilderCustomizer> list = new ArrayList<>();
        list.add(new MongoPropertiesClientSettingsBuilderCustomizer(properties, env));
        return new ReactiveMongoClientFactory(list);
    }

    @Bean
    public ObjectMapperI objectMapperI() {
        return new ObjectMapperI();
    }

    @Bean
    public SubscriberEvent subscriberEvent(EventStoreRepository eventStoreRepository, EventBus eventBus) {
        return new SubscriberEvent(eventStoreRepository, eventBus);
    }

    @Bean
    public ServiceBuilder serviceBuilder(
    ) {
        ServiceBuilder serviceBuilder = new ServiceBuilder();
        return serviceBuilder;
    }

    @Bean
    public RabbitAdmin rabbitmqAdmin(RabbitTemplate rabbitmqTemplate) {
        var admin = new RabbitAdmin(rabbitmqTemplate);
        admin.declareExchange(new TopicExchange(EXCHANGE));
        return admin;
    }
}

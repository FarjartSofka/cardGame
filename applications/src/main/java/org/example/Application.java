package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


@SpringBootApplication
public class Application {

    private final static String QUEUE_NAME = "hello";

    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }
}

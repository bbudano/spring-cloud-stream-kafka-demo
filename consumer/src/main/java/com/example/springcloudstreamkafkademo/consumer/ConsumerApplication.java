package com.example.springcloudstreamkafkademo.consumer;

import com.example.springcloudstreamkafkademo.integration.ProcessedMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@Slf4j
@SpringBootApplication
public class ConsumerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }

    @Bean
    Consumer<Message<ProcessedMessage>> consume() {
        return message -> log.info("Received message, payload: {} headers: {}",
                message.getPayload(), message.getHeaders());
    }

}

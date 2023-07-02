package com.example.springcloudstreamkafkademo.processor;

import com.example.springcloudstreamkafkademo.integration.ExampleMessage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@SpringBootApplication
public class ProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessorApplication.class, args);
	}

	@Bean
	Consumer<Message<ExampleMessage>> processMessage() {
		return message -> System.out.println(message.getPayload());
	}

}

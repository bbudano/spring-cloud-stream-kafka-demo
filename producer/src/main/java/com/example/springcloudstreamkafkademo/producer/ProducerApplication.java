package com.example.springcloudstreamkafkademo.producer;

import com.example.springcloudstreamkafkademo.integration.ExampleMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.UUID;

@Slf4j
@SpringBootApplication
@EnableScheduling
public class ProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProducerApplication.class, args);
	}

	@Autowired
	private StreamBridge streamBridge;

	@Scheduled(initialDelay = 5000L, fixedRate = 5000L)
	public void sendMessage() {
		ExampleMessage message = new ExampleMessage(UUID.randomUUID().toString(), "HELLO");
		log.info("Publishing message, payload: {}", message);
		streamBridge.send("exampleMessage-out-0", message);
	}

}

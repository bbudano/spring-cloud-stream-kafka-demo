package com.example.springcloudstreamkafkademo.processor;

import com.example.springcloudstreamkafkademo.integration.ExampleMessage;
import com.example.springcloudstreamkafkademo.processor.mapper.MessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;

import java.util.function.Consumer;

@SpringBootApplication
public class ProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcessorApplication.class, args);
	}

	@Autowired
	private MessageMapper messageMapper;

	@Bean
	Consumer<Message<ExampleMessage>> processMessage(StreamBridge streamBridge) {
		return message -> {
			var processedMessage = messageMapper.toProcessedMessage(message.getPayload());
			streamBridge.send("processMessage-out-0", processedMessage);
		};
	}

}

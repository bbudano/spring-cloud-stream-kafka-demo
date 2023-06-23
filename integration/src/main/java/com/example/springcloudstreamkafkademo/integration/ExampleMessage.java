package com.example.springcloudstreamkafkademo.integration;

import java.time.Instant;

public record ExampleMessage(String id, String data, Instant timestamp) {
}

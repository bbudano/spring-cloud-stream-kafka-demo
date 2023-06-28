package com.example.springcloudstreamkafkademo.integration;

import java.time.Instant;

public record ProcessedMessage(String id, String data, Instant processedAt) {
}

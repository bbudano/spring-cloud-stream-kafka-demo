package com.example.springcloudstreamkafkademo.integration;

public record ProcessedMessage(String id, String data, String processedAt) {
}

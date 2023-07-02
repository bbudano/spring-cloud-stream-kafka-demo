package com.example.springcloudstreamkafkademo.processor.mapper;

import com.example.springcloudstreamkafkademo.integration.ExampleMessage;
import com.example.springcloudstreamkafkademo.integration.ProcessedMessage;
import org.mapstruct.*;

import java.time.Instant;
import java.util.Objects;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR,
        unmappedTargetPolicy = ReportingPolicy.WARN, imports = { Instant.class })
public interface MessageMapper {

    @Mapping(target = "data", source = "data", qualifiedByName = "mapData")
    @Mapping(target = "processedAt", expression = "java( Instant.now().toString() )")
    ProcessedMessage toProcessedMessage(ExampleMessage exampleMessage);

    @Named("mapData")
    default String mapData(final String data) {
        return Objects.isNull(data) ? null : data.trim().toLowerCase();
    }

}

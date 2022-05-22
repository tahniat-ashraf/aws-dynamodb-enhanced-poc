package com.bkash.dynamoenhancedpoc.configuration;

import com.bkash.dynamoenhancedpoc.service.ConfigurationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import software.amazon.awssdk.enhanced.dynamodb.DynamoDbEnhancedAsyncClient;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.dynamodb.DynamoDbAsyncClient;

import java.net.URI;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class DatabaseConfig {

    private final ConfigurationService configurationService;
    private final Environment environment;

    @Bean
    public DynamoDbEnhancedAsyncClient getDynamoDBEnhancedClient() {

        return DynamoDbEnhancedAsyncClient.builder()
                .dynamoDbClient(getDynamoDbClient())
                .build();
    }

    @Bean
    public DynamoDbAsyncClient getDynamoDbClient() {

        log.info("Dynamo hostIP {}, region {}", configurationService.getDynamoURL(), configurationService.getRegion());


        if (environment.getActiveProfiles()[0].compareTo("dev") == 0) {

            return DynamoDbAsyncClient.builder()
                    .endpointOverride(URI.create(configurationService.getDynamoURL()))
                    .region(Region.of(configurationService.getRegion()))
                    .build();
        } else {
            return DynamoDbAsyncClient.create();
        }
    }
}

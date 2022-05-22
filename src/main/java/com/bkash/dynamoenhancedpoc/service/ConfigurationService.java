package com.bkash.dynamoenhancedpoc.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Data
@Service
public class ConfigurationService {


    @Value("${dynamo.url}")
    private String dynamoURL;

    @Value("${aws.region}")
    private String region;

}


package com.bkash.dynamoenhancedpoc.dao;


import lombok.*;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbPartitionKey;

import java.time.Instant;

@DynamoDbBean
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
public class Student {

    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private Address address;
    private Instant createdDate;


    @DynamoDbPartitionKey
    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        return address;
    }

    public Instant getCreatedDate() {
        return createdDate;
    }
}

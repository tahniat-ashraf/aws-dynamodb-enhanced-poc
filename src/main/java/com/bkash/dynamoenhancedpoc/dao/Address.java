package com.bkash.dynamoenhancedpoc.dao;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import software.amazon.awssdk.enhanced.dynamodb.mapper.annotations.DynamoDbBean;

@DynamoDbBean
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Builder
public class Address {

    private String road;
    private String district;
    private String flatNo;

    public String getRoad() {
        return road;
    }

    public String getDistrict() {
        return district;
    }

    public String getFlatNo() {
        return flatNo;
    }
}

package com.example.microservice.licensingservice.model;

import lombok.Builder;
import lombok.Getter;

@Builder(setterPrefix = "with")
@Getter
public class License {

    private String id;
    private String organizationId;
    private String productName;
    private String licenseType;
}

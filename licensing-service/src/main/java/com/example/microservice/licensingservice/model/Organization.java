package com.example.microservice.licensingservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Organization {
    String id;
    String name;
    String contactName;
    String contactEmail;
    String contactPhone;
}

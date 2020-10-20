package com.example.microservice.licensingservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class DiscoveryService {

    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;

    public List<String> getEurekaServices(){
        List<String> services = new ArrayList<>();

        discoveryClient.getServices().forEach(serviceName -> {
            discoveryClient.getInstances(serviceName).forEach(instance->{
                services.add( String.format("%s:%s",serviceName,instance.getUri()));
            });
        });

        return services;
    }
}

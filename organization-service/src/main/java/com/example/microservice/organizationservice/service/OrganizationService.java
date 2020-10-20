package com.example.microservice.organizationservice.service;

import com.example.microservice.organizationservice.model.Organization;
import com.example.microservice.organizationservice.repository.OrganizationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class OrganizationService {

    private final OrganizationRepository orgRepository;

    public Organization getOrg(String organizationId) {

        Optional<Organization> organization = orgRepository.findById(organizationId);
        if (!organization.isPresent())
            throw new NullPointerException("organizationId-" + organizationId);
        return organization.get();
    }

    public void saveOrg(Organization org){
        org.setId(UUID.randomUUID().toString());

        orgRepository.save(org);
    }

    public void updateOrg(Organization org){
        orgRepository.save(org);
    }

    public void deleteOrg(Organization org){
        orgRepository.delete(org);
    }
}

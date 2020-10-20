package com.example.microservice.organizationservice.repository;

import com.example.microservice.organizationservice.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizationRepository extends JpaRepository<Organization,String> {
}

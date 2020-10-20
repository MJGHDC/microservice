package com.example.microservice.licensingservice.repository;

import com.example.microservice.licensingservice.model.License;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LicenseRepository extends JpaRepository<License,String> {
    List<License> findByOrganizationId(String organizationId);
    License findByOrganizationIdAndLicenseId(String organizationId,String licenseId);
}

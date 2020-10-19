package com.example.microservice.licensingservice.controller;

import com.example.microservice.licensingservice.model.License;
import com.example.microservice.licensingservice.service.LicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

    private final LicenseService licenseService;

    @GetMapping(value="/{licenseId}")
    public License getLicenses(@PathVariable("organizationId") String organizationId,
                               @PathVariable("licenseId") String licenseId) {

        //return licenseService.getLicense(licenseId);
        return new License()
                .withId(licenseId)
                .withOrganizationId(organizationId)
                .withProductName("Teleco")
                .withLicenseType("Seat");
    }

    @PutMapping(value="{licenseId}")
    public String updateLicenses(@PathVariable("licenseId") String licenseId) {
        return "This is the put";
    }

    @PostMapping(value="{licenseId}")
    public String saveLicenses(@PathVariable("licenseId") String licenseId) {
        return "This is the post";
    }

    @DeleteMapping(value="{licenseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteLicenses(@PathVariable("licenseId") String licenseId) {
        return "This is the Delete";
    }
}

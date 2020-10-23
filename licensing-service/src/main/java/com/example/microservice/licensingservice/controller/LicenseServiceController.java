package com.example.microservice.licensingservice.controller;

import com.example.microservice.licensingservice.config.ServiceConfig;
import com.example.microservice.licensingservice.model.License;
import com.example.microservice.licensingservice.service.LicenseService;
import com.example.microservice.licensingservice.utils.UserContextHolder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value="v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {

    private final LicenseService licenseService;
    private final ServiceConfig serviceConfig;

    @GetMapping(value="")
    public List<License> getLicenses(@PathVariable("organizationId") String organizationId) {

        log.debug("LicenseServiceController Correlation id: {}", UserContextHolder.getContext().getCorrelationId());
        return licenseService.getLicensesByOrg(organizationId);
    }

    @GetMapping(value="/{licenseId}")
    public License getLicenses(@PathVariable("organizationId") String organizationId,
                               @PathVariable("licenseId") String licenseId) {


        return licenseService.getLicense(organizationId, licenseId, "");
    }

    @GetMapping(value="/{licenseId}/{clientType}")
    public License getLicensesWithClient(@PathVariable("organizationId") String organizationId,
                                         @PathVariable("licenseId") String licenseId,
                                         @PathVariable("clientType") String clientType) {

        return licenseService.getLicense(organizationId,licenseId, clientType);
    }

    @PutMapping(value="/{licenseId}")
    public void updateLicenses( @PathVariable("licenseId") String licenseId, @RequestBody License license) {
        licenseService.updateLicense(license);
    }

    @PostMapping(value="/")
    public void saveLicenses(@RequestBody License license) {
        licenseService.saveLicense(license);
    }

    @DeleteMapping(value="/{licenseId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteLicenses( @PathVariable("licenseId") String licenseId, @RequestBody License license) {
        licenseService.deleteLicense(license);
    }
}

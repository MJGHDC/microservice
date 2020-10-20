package com.example.microservice.organizationservice.controller;

import com.example.microservice.organizationservice.model.Organization;
import com.example.microservice.organizationservice.service.OrganizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value="v1/organizations")
public class OrganizationServiceController {

    private final OrganizationService orgService;
    private long count = 0L;
    @GetMapping(value="/{organizationId}")
    public Organization getOrganization(@PathVariable("organizationId") String organizationId) {
        System.out.println("haha" + (count++));
        return orgService.getOrg(organizationId);
    }

    @PutMapping(value="/{organizationId}")
    public void updateOrganization(@PathVariable("organizationId") String orgId, @RequestBody Organization org) {
        orgService.updateOrg(org);
    }

    @PostMapping(value="/{organizationId}")
    public void saveOrganization(@RequestBody Organization org) {
        orgService.saveOrg(org);
    }

    @DeleteMapping(value="/{organizationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteOrganization(@PathVariable("orgId") String orgId,  @RequestBody Organization org) {
        orgService.deleteOrg(org);
    }
}

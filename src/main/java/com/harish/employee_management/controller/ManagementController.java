package com.harish.employee_management.controller;

import com.harish.employee_management.model.Hike;
import com.harish.employee_management.model.Onboard;
import com.harish.employee_management.service.ManagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manage")
public class ManagementController {
    @Autowired
    ManagementService service;

    @PostMapping("/onboard")
    public String onboardEmployee(@RequestBody Onboard onboard) {
        service.onboardEmployee(onboard);
        return "Successfully onboarded";
    }

    @PostMapping("/pramote")
    public String promoteEmployee(@RequestBody Hike hike) {
        service.promoteEmployee(hike);
        return "successfully promoted employee " + hike.getEmployeeId();
    }
}

package com.harish.employee_management.controller;

import com.harish.employee_management.model.Salary;
import com.harish.employee_management.repository.SalaryRepository;
import com.harish.employee_management.service.SalaryService;
import lombok.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salary")
public class SalaryController {
    @Autowired
    SalaryService service;

    @GetMapping("/id")
    public Salary getSalaryById(@RequestParam Integer employeeId) {
        return service.getSalary(employeeId);
    }

    @PutMapping("/add")
    public Salary addSalary(@RequestBody Salary salary) {
        return service.addSalary(salary);
    }

    @PostMapping("/update")
    public Salary updateSalary(@RequestBody Salary salary) {
        return service.updateSalary(salary);
    }

    @DeleteMapping("/delete")
    public String deleteSalary(@RequestParam Integer employeeId) {
        return service.deleteSalary(employeeId);
    }

}

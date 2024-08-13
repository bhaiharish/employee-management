package com.harish.employee_management.controller;

import com.harish.employee_management.model.Department;
import com.harish.employee_management.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dept")
public class DepartmentController {
    @Autowired
    DepartmentRepository repository;

    @GetMapping("/department")
    public Department getDepartmentByID(@RequestParam String id) {
        return repository.findById(id).get();
    }
}

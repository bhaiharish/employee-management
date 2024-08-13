package com.harish.employee_management.controller;

import com.harish.employee_management.model.DeptManager;
import com.harish.employee_management.repository.DeptManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/deptmanager")
public class DeptManagerController {
    @Autowired
    DeptManagerRepository repository;

    @GetMapping("/deptManager")
    public DeptManager getDeptManagerByID(@RequestParam Integer id) {
        return repository.findById(id).get();
    }
}

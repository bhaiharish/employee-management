package com.harish.employee_management.controller;

import com.harish.employee_management.model.DeptEmp;
import com.harish.employee_management.model.DeptManager;
import com.harish.employee_management.repository.DeptEmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/depemp")
public class DeptEmpController {

    @Autowired
    DeptEmpRepository repository;

    @GetMapping("/deptEmp")
    public DeptEmp getDeptEmpById(@RequestParam Integer id){
        return repository.findById(id).get();
    }

}

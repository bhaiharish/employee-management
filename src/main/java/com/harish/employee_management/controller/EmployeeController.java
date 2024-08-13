package com.harish.employee_management.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.harish.employee_management.model.Employee;
import com.harish.employee_management.model.Salary;
import com.harish.employee_management.model.Title;
import com.harish.employee_management.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping("/get")
    public Employee getEmployee(@RequestParam Integer id) {
        return service.getEmployee(id);
    }

    @GetMapping("/{id}/salary")
    public Salary getEmployeeSalary(@PathVariable("id") Integer id){
        return service.getSalaryOfEmployee(id);
    }

    @GetMapping("/{id}/title")
    public Title getEmployeeTitle(@PathVariable("id") Integer id) {
        return service.getTitleOfEmployee(id);
    }

    @GetMapping("/sqs")
    public String sendSqs(@RequestParam Integer id) throws JsonProcessingException {
        service.sendMessageSQS(id);
        return "sent successfully";
    }
}

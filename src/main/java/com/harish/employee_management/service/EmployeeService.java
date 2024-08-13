package com.harish.employee_management.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.harish.employee_management.cloud.SqsMessageService;
import com.harish.employee_management.model.AppraisalRequestModel;
import com.harish.employee_management.model.Employee;
import com.harish.employee_management.model.Salary;
import com.harish.employee_management.model.Title;
import com.harish.employee_management.repository.EmployeeRepository;
import com.harish.employee_management.repository.SalaryRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeService {

    private static final String APPRAISAL_REQUEST_QUEUE =
            "https://sqs.ap-south-1.amazonaws.com/339712861729/appraisal-initiating-queue";
    @Autowired
    EmployeeRepository repository;
    @Autowired
    SalaryService salaryService;
    @Autowired
    TitleService titleService;
    @Autowired
    SqsMessageService messageService;

    public Employee getEmployee(Integer id) {
        return repository.findById(id).get();
    }

    public String deleteEmployee(Integer id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            System.out.println("error in deleting a Employee " + e);
        }
        return "successfully deleted a Employee";
    }

    public Employee addEmployee(Employee employee) {
        return repository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        Employee oldEmployee = repository.findById(employee.getEmp_no()).get();
        oldEmployee.setBirth_date(employee.getBirth_date());
        oldEmployee.setFirst_name(employee.getFirst_name());
        oldEmployee.setGender(employee.getGender());
        oldEmployee.setHire_date(employee.getHire_date());
        oldEmployee.setLast_name(employee.getLast_name());
        return repository.save(oldEmployee);
    }

    public Salary getSalaryOfEmployee(Integer id) {
        return salaryService.getSalary(id);
    }

    public Title getTitleOfEmployee(Integer id) {
        return titleService.getTitle(id);
    }

    public void sendMessageSQS(Integer id) throws JsonProcessingException {
        Employee employee = repository.findById(id).get();
        AppraisalRequestModel.AppraisalRequestModelBuilder builder = AppraisalRequestModel.builder();
        builder.emp_no(employee.getEmp_no());
        String title = getTitleOfEmployee(employee.getEmp_no()).getTitle();
        Integer salary = getSalaryOfEmployee(employee.getEmp_no()).getSalary();
        builder.title(title);
        builder.hike(10);
        builder.salary(salary);
        AppraisalRequestModel requestModel = builder.build();
        try {
            messageService.send(APPRAISAL_REQUEST_QUEUE, requestModel);
        } catch (Exception e) {
            System.out.println("failed to send error");
        }

        System.out.println("sqs message sent");
    }
}

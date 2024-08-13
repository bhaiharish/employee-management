package com.harish.employee_management.service;

import com.harish.employee_management.model.Hike;
import com.harish.employee_management.model.Onboard;
import com.harish.employee_management.model.Salary;
import com.harish.employee_management.model.Title;
import com.harish.employee_management.repository.DepartmentRepository;
import com.harish.employee_management.repository.EmployeeRepository;
import com.harish.employee_management.repository.SalaryRepository;
import com.harish.employee_management.repository.TitleRepository;
import org.hibernate.internal.util.StringHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class ManagementService {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
    SalaryRepository salaryRepository;
    @Autowired
    TitleRepository titleRepository;
    public void onboardEmployee(Onboard onboard) {
        employeeRepository.save(onboard.getEmployee());
        departmentRepository.save(onboard.getDepartment());
        titleRepository.save(Title.builder()
                .emp_no(onboard.getEmployee().getEmp_no())
                .title(onboard.getTitle())
                .to_date(onboard.getTo_date())
                .from_date(onboard.getFrom_date())
                .build());
    }

    public void promoteEmployee(Hike hike) {
        Title title = titleRepository.findById(hike.getEmployeeId()).get();
        title.setTitle(hike.getNewTitle());
        titleRepository.save(title);

        Salary salary = salaryRepository.findById(hike.getEmployeeId()).get();
        Integer increasedAmount = (int) ((salary.getSalary() * hike.getHikePercentage())/100);
        salary.setSalary(salary.getSalary() + increasedAmount);
        salaryRepository.save(salary);
    }

    public void validateTitle(String oldTitle, String newTitle) {
        switch (newTitle) {
            case "Engineer":
                if(!Objects.equals(oldTitle, "Assistant Engineer")) throw new RuntimeException("can't promote to this position");
                break;
            case "Senior Engineer":
                if(!Objects.equals(oldTitle, "Engineer")) throw new RuntimeException("can't promote to this position");
                break;
            case "Senior Developer":
                if(!Objects.equals(oldTitle, "Software Developer")) throw new RuntimeException("can't promote to this position");
                break;
            case "Technique Leader":
                if(!Objects.equals(oldTitle, "Senior Developer")) throw new RuntimeException("can't promote to this position");
                break;
            case "Manager":
                if(!Objects.equals(oldTitle, "Technique Leader")) throw new RuntimeException("can't promote to this position");
                break;
            case "Senior Staff":
                if(!Objects.equals(oldTitle, "Staff")) throw new RuntimeException("can't promote to this position");
                break;
        }
    }
}

package com.harish.employee_management.service;

import com.harish.employee_management.model.Salary;
import com.harish.employee_management.repository.SalaryRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class SalaryService {
    @Autowired
    SalaryRepository repository;

    public Salary getSalary(Integer id) {
        return repository.findByEmp_No(id).stream().findFirst().get();
    }

    public String deleteSalary(Integer id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            System.out.println("error in deleting a Salary " + e);
        }
        return "successfully deleted a Salary";
    }

    public Salary addSalary(Salary salary) {
        return repository.save(salary);
    }

    public Salary updateSalary(Salary salary) {
        Salary oldSalary = repository.findById(salary.getEmp_no()).get();
        oldSalary.setSalary(salary.getSalary());
        oldSalary.setFrom_date(salary.getFrom_date());
        oldSalary.setTo_date(salary.getTo_date());
        return repository.save(oldSalary);
    }
}

package com.harish.employee_management.service;

import com.harish.employee_management.model.Title;
import com.harish.employee_management.repository.EmployeeRepository;
import com.harish.employee_management.repository.TitleRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class TitleService {

    private static final List<String> allowedTitles =
            List.of("Software Developer","Senior Engineer","Senior Developer",
                    "Staff","Engineer","Senior Staff",
                    "Assistant Engineer","Technique Leader","Manager");

    @Autowired
    TitleRepository repository;

    @Autowired
    EmployeeRepository employeeRepository;

    public Title getTitle(Integer id) {
        return repository.findById(id).get();
    }

    public String deleteTitle(Integer id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            System.out.println("error in deleting a title " + e);
        }
        return "successfully deleted a title";
    }

    public Title addTitle(Title title) {
        return repository.save(title);
    }

    public Title updateTitle(Title title) {
        Title oldTitle = repository.findById(title.getEmp_no()).get();
        oldTitle.setTitle(title.getTitle());
        oldTitle.setFrom_date(title.getFrom_date());
        oldTitle.setTo_date(title.getTo_date());
        return repository.save(oldTitle);
    }

    private void validate(Title title) {
        validateEmployee(title.getEmp_no());
        validateTitle(title.getTitle());
    }

    private void validateEmployee(Integer employeeId) {
        if(employeeRepository.findById(employeeId).isEmpty())
            throw new RuntimeException("Employee Not Found");
    }

    private void validateTitle(String name) {
        if(!allowedTitles.contains(name))
            throw new RuntimeException("This title is not allowed");
    }
}

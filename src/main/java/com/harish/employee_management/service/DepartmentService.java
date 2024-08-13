package com.harish.employee_management.service;

import com.harish.employee_management.model.Department;
import com.harish.employee_management.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentService {

    @Autowired
    DepartmentRepository repository;

    public Department getDepartment(String id) {
        return repository.findById(id).get();
    }

    public String deleteDepartment(String id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            System.out.println("error in deleting a Department " + e);
        }
        return "successfully deleted a Department";
    }

    public Department addDepartment(Department department) {
        return repository.save(department);
    }

    public Department updateDepartment(Department department) {
        Department oldDepartment = repository.findById(department.getDept_no()).get();
        oldDepartment.setDept_name(department.getDept_name());
        return repository.save(oldDepartment);
    }
}

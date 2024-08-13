package com.harish.employee_management.repository;

import com.harish.employee_management.model.DeptEmp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptEmpRepository extends JpaRepository<DeptEmp, Integer> {
}

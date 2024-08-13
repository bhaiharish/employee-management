package com.harish.employee_management.repository;

import com.harish.employee_management.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalaryRepository extends JpaRepository<Salary,Integer> {
    @Query("SELECT s FROM Salary s WHERE s.emp_no =?1 order by from_date desc")
    List<Salary> findByEmp_No(Integer emp_no);
}

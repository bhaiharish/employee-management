package com.harish.employee_management.repository;

import com.harish.employee_management.model.DeptManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptManagerRepository extends JpaRepository<DeptManager,Integer> {
}

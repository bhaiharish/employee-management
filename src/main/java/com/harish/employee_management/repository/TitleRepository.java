package com.harish.employee_management.repository;

import com.harish.employee_management.model.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TitleRepository extends JpaRepository<Title,Integer> {
}

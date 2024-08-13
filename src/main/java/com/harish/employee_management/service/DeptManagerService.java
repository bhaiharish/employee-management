package com.harish.employee_management.service;

import com.harish.employee_management.model.DeptManager;
import com.harish.employee_management.repository.DeptManagerRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class DeptManagerService {
    @Autowired
    DeptManagerRepository repository;

    public DeptManager getDeptManager(Integer id) {
        return repository.findById(id).get();
    }

    public String deleteDeptManager(Integer id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            System.out.println("error in deleting a DeptManager " + e);
        }
        return "successfully deleted a DeptManager";
    }

    public DeptManager addDeptManager(DeptManager DeptManager) {
        return repository.save(DeptManager);
    }

    public DeptManager updateDeptManager(DeptManager DeptManager) {
        DeptManager oldDeptManager = repository.findById(DeptManager.getEmp_no()).get();
        oldDeptManager.setDept_no(DeptManager.getDept_no());
        oldDeptManager.setFrom_date(DeptManager.getFrom_date());
        oldDeptManager.setTo_date(DeptManager.getTo_date());
        return repository.save(oldDeptManager);
    }
}

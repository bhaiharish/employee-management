package com.harish.employee_management.service;

import com.harish.employee_management.model.DeptEmp;
import com.harish.employee_management.repository.DeptEmpRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class DeptEmpService {

    @Autowired
    DeptEmpRepository repository;

    public DeptEmp getDeptEmp(Integer id) {
        return repository.findById(id).get();
    }

    public String deleteDeptEmp(Integer id) {
        try {
            repository.deleteById(id);
        } catch (Exception e) {
            System.out.println("error in deleting a DeptEmp " + e);
        }
        return "successfully deleted a DeptEmp";
    }

    public DeptEmp addDeptEmp(DeptEmp deptEmp) {
        return repository.save(deptEmp);
    }

    public DeptEmp updateDeptEmp(DeptEmp deptEmp) {
        DeptEmp oldDeptEmp = repository.findById(deptEmp.getEmp_id()).get();
        oldDeptEmp.setDept_no(deptEmp.getDept_no());
        oldDeptEmp.setFrom_date(deptEmp.getFrom_date());
        oldDeptEmp.setTo_date(deptEmp.getTo_date());
        return repository.save(oldDeptEmp);
    }
}

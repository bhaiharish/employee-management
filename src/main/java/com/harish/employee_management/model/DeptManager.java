package com.harish.employee_management.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "dept_manager")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptManager {
    @Id
    private Integer emp_no;
    private String dept_no;
    private Date from_date;
    private Date to_date;
}

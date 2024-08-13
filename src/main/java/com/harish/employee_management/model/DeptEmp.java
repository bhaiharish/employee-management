package com.harish.employee_management.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "dept_emp")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeptEmp {
    @Id
    private Integer emp_id;
    private String dept_no;
    private Date from_date;
    private Date to_date;

}

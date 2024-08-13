package com.harish.employee_management.model;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "departments")
public class Department {
    @Id
    private String dept_no;
    private String dept_name;

}

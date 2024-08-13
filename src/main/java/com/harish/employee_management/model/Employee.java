package com.harish.employee_management.model;

import javax.persistence.*;
import lombok.Data;

import java.sql.Date;

@Entity
@Table(name = "employees")
@Data
public class Employee {

    @Id
    private Integer emp_no;
    private Date birth_date;
    private String first_name;
    private String last_name;
    @Enumerated
    private Gender gender;

    private Date hire_date;
}

package com.harish.employee_management.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name = "salaries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Salary {
    @Id
    private Integer id;
    private Integer emp_no;
    private Integer salary;
    private Date from_date;
    private Date to_date;
}

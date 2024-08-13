package com.harish.employee_management.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Onboard {

    private Employee employee;
    private Department department;

    private Integer salary;
    private String title;

    private Date from_date;

    private Date to_date;

}

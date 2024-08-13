package com.harish.employee_management.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Table(name = "titles")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Title {
    @Id
    private Integer emp_no;
    private String title;
    private Date from_date;
    private Date to_date;
}

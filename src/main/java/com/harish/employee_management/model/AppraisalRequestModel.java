package com.harish.employee_management.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AppraisalRequestModel {
    private Integer emp_no;
    private Integer salary;
    private Integer hike;
    private String title;
}

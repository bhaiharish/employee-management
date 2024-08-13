package com.harish.employee_management.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Hike {
    private Integer EmployeeId;
    private String newTitle;
    private double hikePercentage;
}

package com.employee.response;

import com.employee.entity.Department;
import lombok.Data;

@Data
public class EmployeeResponse {

    private Long id;

    private String employeeName;

    private Department department;
}

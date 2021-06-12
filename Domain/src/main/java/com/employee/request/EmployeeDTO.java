package com.employee.request;


import com.employee.entity.Department;
import lombok.Data;

import javax.persistence.*;

@Data
public class EmployeeDTO {

    private String employeeName;

    private Long departmentId;
}

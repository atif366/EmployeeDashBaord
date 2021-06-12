package com.employee.services.department;

import com.employee.constants.DashBoardConstants;
import com.employee.entity.Department;
import com.employee.entity.Employee;
import com.employee.exception.EntityNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface DepartmentService {

    public Department persistDepartment(Department department);

    public List<Department> findAllDepartment();

    public Department departmentById(Long id) throws EntityNotFoundException;

    public Department updateDepartment(Long id, @RequestBody Department department) throws EntityNotFoundException;

    public Department removeDepartment(@PathVariable Long id) throws EntityNotFoundException;

}

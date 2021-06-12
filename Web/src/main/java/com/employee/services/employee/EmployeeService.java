package com.employee.services.employee;

import com.employee.constants.DashBoardConstants;
import com.employee.entity.Employee;
import com.employee.exception.EntityNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface EmployeeService {

    public Employee persistEmployee(Employee employee);

    public List<Employee> findAllEmployee();

    public Employee employeeById(Long id) throws EntityNotFoundException;

    public Employee updateEmployee(Long id, @RequestBody Employee employee) throws EntityNotFoundException;

    public Employee removeEmployee(@PathVariable Long id) throws EntityNotFoundException;
}

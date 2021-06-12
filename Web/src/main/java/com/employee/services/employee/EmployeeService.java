package com.employee.services.employee;

import com.employee.exception.EntityNotFoundException;
import com.employee.request.EmployeeDTO;
import com.employee.response.EmployeeResponse;

import java.util.List;

public interface EmployeeService {

    public EmployeeDTO persistEmployee(EmployeeDTO employeeDTO) throws EntityNotFoundException;

    public List<EmployeeResponse> findAllEmployee();

    public EmployeeDTO employeeById(Long id) throws EntityNotFoundException;

    public EmployeeDTO updateEmployee(Long id,EmployeeDTO employeeDTO) throws EntityNotFoundException;

    public EmployeeDTO removeEmployee(Long id) throws EntityNotFoundException;
}

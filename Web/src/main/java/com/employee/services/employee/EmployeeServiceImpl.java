package com.employee.services.employee;


import com.employee.constants.DashBoardConstants;
import com.employee.entity.Department;
import com.employee.entity.Employee;
import com.employee.exception.EntityNotFoundException;
import com.employee.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class EmployeeServiceImpl implements  EmployeeService{


    EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    public Employee persistEmployee(Employee employee){
        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployee(){
        return employeeRepo.findAll();
    }

    public Employee employeeById(Long id) throws EntityNotFoundException {
        return employeeRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(DashBoardConstants.ID_NOT_EXIST));
    }

    public Employee updateEmployee(Long id, @RequestBody Employee employee) throws EntityNotFoundException {
        employeeById(id);
        return employeeRepo.save(employee);
    }

    public Employee removeEmployee(@PathVariable Long id) throws EntityNotFoundException {
        Employee employee = employeeById(id);
        employeeRepo.delete(employee);
        return employee;
    }



}

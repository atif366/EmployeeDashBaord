package com.employee.services.employee;


import com.employee.config.model.ModelMapperImpl;
import com.employee.constants.DashBoardConstants;
import com.employee.entity.Department;
import com.employee.entity.Employee;
import com.employee.exception.EntityNotFoundException;
import com.employee.repository.EmployeeRepo;
import com.employee.request.DepartmentDTO;
import com.employee.request.EmployeeDTO;
import com.employee.response.EmployeeResponse;
import com.employee.services.department.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements  EmployeeService{


    private final EmployeeRepo employeeRepo;

    private final DepartmentService departmentService;

    private final ModelMapperImpl modelMapper;


    public EmployeeServiceImpl(EmployeeRepo employeeRepo,ModelMapperImpl modelMapper,DepartmentService departmentService) {
        this.employeeRepo = employeeRepo;
        this.modelMapper =modelMapper;
        this.departmentService = departmentService;
    }

    public EmployeeDTO persistEmployee(EmployeeDTO employeeDTO) throws EntityNotFoundException {
        DepartmentDTO departmentById = departmentService.departmentById(employeeDTO.getDepartmentId());
        Employee employee = (Employee) modelMapper.convert(employeeDTO,Employee.class);
        employee.setDepartment((Department) modelMapper.convert(departmentById,Department.class));
        employee.setId(employeeRepo.getMaxId()+1);
        return (EmployeeDTO) modelMapper.convert(employeeRepo.save(employee),EmployeeDTO.class);
    }

    public List<EmployeeResponse> findAllEmployee(){
        return employeeRepo.findAll().stream()
                 .map(emp ->  (EmployeeResponse) modelMapper.convert(emp, EmployeeResponse.class))
                .collect(Collectors.toList());
    }

    public EmployeeDTO employeeById(Long id) throws EntityNotFoundException {
        Employee employee = employeeRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(DashBoardConstants.ID_NOT_EXIST));
        return (EmployeeDTO) modelMapper.convert(employee,EmployeeDTO.class);
    }

    public EmployeeDTO updateEmployee(Long id, @RequestBody EmployeeDTO employeeDTO) throws EntityNotFoundException {
        DepartmentDTO departmentById = departmentService.departmentById(employeeDTO.getDepartmentId());
        EmployeeDTO employeeById = employeeById(id);
        Employee employee = (Employee) modelMapper.convert(employeeDTO,Employee.class);
        employee.setDepartment((Department) modelMapper.convert(departmentById,Department.class));
        employee.setId(employeeById.getId());
        return (EmployeeDTO) modelMapper.convert(employeeRepo.save(employee),EmployeeDTO.class);
    }

    public EmployeeDTO removeEmployee(@PathVariable Long id) throws EntityNotFoundException {
        EmployeeDTO employeeDTO = employeeById(id);
        employeeRepo.delete((Employee) modelMapper.convert(employeeDTO,Employee.class));
        return employeeDTO;
    }



}

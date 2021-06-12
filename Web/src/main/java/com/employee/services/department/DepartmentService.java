package com.employee.services.department;

import com.employee.constants.DashBoardConstants;
import com.employee.entity.Department;
import com.employee.entity.Employee;
import com.employee.exception.EntityNotFoundException;
import com.employee.request.DepartmentDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface DepartmentService {

    public DepartmentDTO persistDepartment(DepartmentDTO departmentDTO);

    public List<DepartmentDTO> findAllDepartment();

    public DepartmentDTO departmentById(Long id) throws EntityNotFoundException;

    public DepartmentDTO updateDepartment(Long id, @RequestBody DepartmentDTO departmentDTO) throws EntityNotFoundException;

    public DepartmentDTO removeDepartment(@PathVariable Long id) throws EntityNotFoundException;

}

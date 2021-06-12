package com.employee.services.department;

import com.employee.constants.DashBoardConstants;
import com.employee.entity.Course;
import com.employee.entity.Department;
import com.employee.exception.EntityNotFoundException;
import com.employee.repository.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {


    DepartmentRepo departmentRepo;

    @Autowired
    public DepartmentServiceImpl(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }

    public Department persistDepartment(Department department){
        return departmentRepo.save(department);
    }

    public List<Department> findAllDepartment(){
        return departmentRepo.findAll();
    }

    public Department departmentById(Long id) throws EntityNotFoundException {
        return departmentRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(DashBoardConstants.ID_NOT_EXIST));
    }

    public Department updateDepartment(Long id, @RequestBody Department department) throws EntityNotFoundException {
        departmentById(id);
        return departmentRepo.save(department);
    }

    public Department removeDepartment(@PathVariable Long id) throws EntityNotFoundException {
        Department department = departmentById(id);
        departmentRepo.delete(department);
        return department;
    }
}

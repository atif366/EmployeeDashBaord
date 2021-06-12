package com.employee.services.department;

import com.employee.config.model.ModelMapperImpl;
import com.employee.constants.DashBoardConstants;
import com.employee.entity.Department;
import com.employee.exception.EntityNotFoundException;
import com.employee.repository.DepartmentRepo;
import com.employee.request.DepartmentDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {


    DepartmentRepo departmentRepo;

    ModelMapperImpl modelMapper;


    public DepartmentServiceImpl(DepartmentRepo departmentRepo,ModelMapperImpl modelMapper) {
        this.departmentRepo = departmentRepo;
        this.modelMapper = modelMapper;
    }

    public DepartmentDTO persistDepartment(DepartmentDTO departmentDTO){
        Department department = (Department) modelMapper.convert(departmentDTO,Department.class);
        department.setId(departmentRepo.getMaxId()+1);
        return (DepartmentDTO) modelMapper.convert(departmentRepo.save(department),DepartmentDTO.class);
    }

    public List<DepartmentDTO> findAllDepartment(){
        return departmentRepo.findAll().stream().map(p -> (DepartmentDTO) modelMapper.convert(p, DepartmentDTO.class))
                .collect(Collectors.toList());
    }

    public DepartmentDTO departmentById(Long id) throws EntityNotFoundException {
        Department department = departmentRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(DashBoardConstants.ID_NOT_EXIST));
        return (DepartmentDTO) modelMapper.convert(department,DepartmentDTO.class);
    }

    public DepartmentDTO updateDepartment(Long id,DepartmentDTO departmentDTO) throws EntityNotFoundException {
        DepartmentDTO departmentById = departmentById(id);
        Department department = (Department) modelMapper.convert(departmentDTO,Department.class);
        department.setId(departmentById.getId());
        return (DepartmentDTO) modelMapper.convert(departmentRepo.save(department),DepartmentDTO.class);
    }

    public DepartmentDTO removeDepartment(Long id) throws EntityNotFoundException {
        DepartmentDTO departmentDto = departmentById(id);
        departmentRepo.delete((Department) modelMapper.convert(departmentDto,Department.class));
        return departmentDto;
    }
}

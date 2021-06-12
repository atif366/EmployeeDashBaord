package com.employee.controller.department;

import com.employee.entity.Department;
import com.employee.exception.EntityNotFoundException;
import com.employee.response.ResponseDTO;
import com.employee.services.department.DepartmentService;
import com.employee.util.ResponseUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard/v1/department")
public class DepartmentController {

    private final ResponseUtil responseUtil;

    private final DepartmentService departmentService;

    public DepartmentController(ResponseUtil responseUtil, DepartmentService departmentService) {
        this.responseUtil = responseUtil;
        this.departmentService = departmentService;
    }

    @ApiOperation(value="Add a Department For Employee")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request")})
    @PostMapping(path = "/")
    public ResponseDTO persistDepartment(@RequestBody Department department){
        return responseUtil.createResponseDto("Department Saved Successfully",200,departmentService.persistDepartment(department));
    }

    @ApiOperation(authorizations = {@Authorization(value="basicAuth")},value="Find all the Department")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "No content found") })
    @GetMapping(path = "/getAll")
    public ResponseDTO  findAllDepartment(){
        return responseUtil.createResponseDto("",200,departmentService.findAllDepartment());
    }

    @ApiOperation(authorizations = {@Authorization(value="basicAuth")},value="Find Department By Department ID")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "No content found") })
    @GetMapping(path = "/get/{id}")
    public ResponseDTO  departmentById(@PathVariable Long id) throws EntityNotFoundException {
        return responseUtil.createResponseDto("",200,departmentService.departmentById(id));
    }


    @ApiOperation(authorizations = {@Authorization(value="basicAuth")},value="Update The Department By DepartmentId")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request")})
    @PutMapping(path = "/update/{id}")
    public ResponseDTO  updateDepartment(@PathVariable Long id,@RequestBody Department department) throws EntityNotFoundException {
        return responseUtil.createResponseDto("",200,departmentService.updateDepartment(id,department));
    }

    @ApiOperation(authorizations = {@Authorization(value="basicAuth")},value="Remove the department by department id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "No content found") })
    @DeleteMapping(path = "/delete/{id}")
    public ResponseDTO  removeDepartment(@PathVariable Long id) throws EntityNotFoundException {
        return responseUtil.createResponseDto("",200,departmentService.removeDepartment(id));
    }
}

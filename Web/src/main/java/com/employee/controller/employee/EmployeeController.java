package com.employee.controller.employee;


import com.employee.entity.Employee;
import com.employee.exception.EntityNotFoundException;
import com.employee.response.ResponseDTO;
import com.employee.services.employee.EmployeeService;
import com.employee.util.ResponseUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard/v1/employee")
public class EmployeeController {

    private final ResponseUtil responseUtil;

    private final EmployeeService employeeService;

    public EmployeeController(ResponseUtil responseUtil, EmployeeService employeeService) {
        this.responseUtil = responseUtil;
        this.employeeService = employeeService;
    }
    @ApiOperation(value="Add a Employee")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request")})
    @PostMapping(path = "/")
    public ResponseDTO persistEmployee(@RequestBody Employee employee){
        return responseUtil.
                createResponseDto("",200,employeeService.persistEmployee(employee));
    }

    @ApiOperation(authorizations = {@Authorization(value="basicAuth")},value="Find All Employee")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "No content found") })
    @GetMapping(path = "/getAll")
    public ResponseDTO  findAllEmployee(){
        return responseUtil.createResponseDto("",200,employeeService.findAllEmployee());
    }

    @ApiOperation(authorizations = {@Authorization(value="basicAuth")},value="Find Employee By Id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "No content found") })
    @GetMapping(path = "/get/{id}")
    public ResponseDTO  departmentById(@PathVariable Long id) throws EntityNotFoundException {
        return responseUtil.createResponseDto("",200,employeeService.employeeById(id));
    }

    @ApiOperation(authorizations = {@Authorization(value="basicAuth")},value="Update Employee By Id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "No content found") })
    @PutMapping(path = "/update/{id}")
    public ResponseDTO  updateDepartment(@PathVariable Long id,@RequestBody Employee employee) throws EntityNotFoundException {
        return responseUtil.createResponseDto("",200,employeeService.updateEmployee(id,employee));
    }

    @ApiOperation(authorizations = {@Authorization(value="basicAuth")},value="Delete Employee By Id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "No content found") })
    @DeleteMapping(path = "/delete/{id}")
    public ResponseDTO  removeDepartment(@PathVariable Long id) throws EntityNotFoundException {
        return responseUtil.createResponseDto("",200,employeeService.removeEmployee(id));
    }
}

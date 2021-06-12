package com.employee.controller.course;


import com.employee.entity.Course;
import com.employee.exception.EntityNotFoundException;
import com.employee.response.ResponseDTO;
import com.employee.services.course.CourseService;
import com.employee.util.ResponseUtil;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dashboard/v1/course")
public class CourseController {


    private final ResponseUtil responseUtil;

    private final CourseService courseService;

    public CourseController(ResponseUtil responseUtil, CourseService courseService) {
        this.responseUtil = responseUtil;
        this.courseService = courseService;
    }

    @ApiOperation(authorizations = {@Authorization(value="basicAuth")},value="Add a Course For Department")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Bad Request")})
    @PostMapping(path = "/")
    public ResponseDTO  persistCourse(@RequestBody Course course){
        return responseUtil.createResponseDto("Course Saved Successfully",200,courseService.persistCourse(course));
    }

    @ApiOperation(authorizations = {@Authorization(value="basicAuth")},value="Find all the course")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "No content found") })
    @GetMapping(path = "/getAll")
    public ResponseDTO  findAllCourse(){
        return responseUtil.createResponseDto("Find all the course",200,courseService.findAllCourse());
    }

    @ApiOperation(authorizations = {@Authorization(value="basicAuth")},value="Find the course by course id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "No content found") })
    @GetMapping(path = "/get/{id}")
    public ResponseDTO  courseById(@PathVariable Long id) throws EntityNotFoundException {
        return responseUtil.createResponseDto("Find Course By Id",200,courseService.courseById(id));
    }


    @ApiOperation(authorizations = {@Authorization(value="basicAuth")},value="Update the course by course id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "Unable to update the the course at this time") })
    @PutMapping(path = "/update/{id}")
    public ResponseDTO  updateCourse(@PathVariable Long id,@RequestBody Course course) throws EntityNotFoundException {
        return responseUtil.createResponseDto("Updated Course Successfully",200,courseService.updateCourse(id,course));
    }

    @ApiOperation(authorizations = {@Authorization(value="basicAuth")},value="Remove the course based on course id")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 500, message = "No content found") })
    @DeleteMapping(path = "/delete/{id}")
    public ResponseDTO  removeCourse(@PathVariable Long id) throws EntityNotFoundException {
        return responseUtil.createResponseDto("Course Removed Successfully",200,courseService.removeCourse(id));
    }
}

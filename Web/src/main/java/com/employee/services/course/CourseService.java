package com.employee.services.course;

import com.employee.constants.DashBoardConstants;
import com.employee.entity.Course;
import com.employee.exception.EntityNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CourseService {

    public Course persistCourse(@RequestBody Course course);

    public List<Course> findAllCourse();

    public Course courseById(Long id) throws EntityNotFoundException;

    public Course updateCourse(@PathVariable Long id, @RequestBody Course course) throws EntityNotFoundException;

    public Course removeCourse(@PathVariable Long id) throws EntityNotFoundException;
}

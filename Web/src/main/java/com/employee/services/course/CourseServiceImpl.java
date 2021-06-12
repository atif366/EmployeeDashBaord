package com.employee.services.course;

import com.employee.constants.DashBoardConstants;
import com.employee.entity.Course;
import com.employee.exception.EntityNotFoundException;
import com.employee.repository.CourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {


    CourseRepo courseRepo;

    @Autowired
    public CourseServiceImpl(CourseRepo courseRepo) {
        this.courseRepo = courseRepo;
    }

    public Course persistCourse(@RequestBody Course course){
        return courseRepo.save(course);
    }

    public List<Course> findAllCourse(){
        return courseRepo.findAll();
    }

    public Course courseById(Long id) throws EntityNotFoundException {
        return courseRepo.findById(id).orElseThrow(() -> new EntityNotFoundException(DashBoardConstants.ID_NOT_EXIST));
    }

    public Course updateCourse(@PathVariable Long id,@RequestBody Course course) throws EntityNotFoundException {
        courseById(id);
        return courseRepo.save(course);
    }

    public Course removeCourse(@PathVariable Long id) throws EntityNotFoundException {
        Course course = courseById(id);
        courseRepo.delete(course);
        return course;
    }
}

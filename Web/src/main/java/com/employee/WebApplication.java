package com.employee;

import com.employee.entity.Course;
import com.employee.entity.Department;
import com.employee.entity.Employee;
import com.employee.entity.ServiceUser;
import com.employee.repository.CourseRepo;
import com.employee.repository.DashBoardUserServiceRepository;
import com.employee.repository.DepartmentRepo;
import com.employee.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class WebApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }


    DashBoardUserServiceRepository dashBoardUserServiceRepository;

    EmployeeRepo employeeRepo;

    DepartmentRepo departmentRepo;

    CourseRepo courseRepo;

    @Autowired
    public WebApplication(DashBoardUserServiceRepository dashBoardUserServiceRepository,
                          EmployeeRepo employeeRepo,DepartmentRepo departmentRepo,CourseRepo courseRepo) {
        this.dashBoardUserServiceRepository = dashBoardUserServiceRepository;
        this.employeeRepo =employeeRepo;
        this.departmentRepo =departmentRepo;
        this.courseRepo =courseRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        dashBoardUserServiceRepository.save(new ServiceUser(1001,"ATIF","ADMIN","123456"));
        dashBoardUserServiceRepository.save(new ServiceUser(1002,"TEST","USER","123456"));
        dashBoardUserServiceRepository.save(new ServiceUser(1003,"DEMO","ADMIN","123456"));

        Course course1 = new Course(101L,"Geometry");
        Course course2 = new Course(102L,"Probability");
        Course course3 = new Course(103L,"Statistics");
        Course course4 = new Course(104L,"Probability");
        Course course5 = new Course(105L,"Algebra");

        departmentRepo.save(new Department(1L,"Mathematics", Arrays.asList(course1,course2,course3,course4,course5)));

        List<Department> all = departmentRepo.findAll();
        //all.stream().forEach();
        //departmentRepo.save(new Department(2L,"Science"));

        //employeeRepo.save(new Employee(101L,"Test",123))

    }
}

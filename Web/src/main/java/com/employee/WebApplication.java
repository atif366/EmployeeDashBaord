package com.employee;

import com.employee.entity.Employee;
import com.employee.entity.ServiceUser;
import com.employee.repository.DashBoardUserServiceRepository;
import com.employee.repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WebApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(WebApplication.class, args);
    }


    DashBoardUserServiceRepository dashBoardUserServiceRepository;

    EmployeeRepo employeeRepo;

    @Autowired
    public WebApplication(DashBoardUserServiceRepository dashBoardUserServiceRepository,EmployeeRepo employeeRepo) {
        this.dashBoardUserServiceRepository = dashBoardUserServiceRepository;
        this.employeeRepo =employeeRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        dashBoardUserServiceRepository.save(new ServiceUser(1001,"ATIF","ADMIN","123456"));
        dashBoardUserServiceRepository.save(new ServiceUser(1002,"TEST","ADMIN","123456"));
        dashBoardUserServiceRepository.save(new ServiceUser(1003,"DEMO","ADMIN","123456"));

        //employeeRepo.save(new Employee(101L,"Test",123))

    }
}

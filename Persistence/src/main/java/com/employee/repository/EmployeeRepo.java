package com.employee.repository;

import com.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    @Query("SELECT coalesce(max(emp.id), 0) FROM Employee emp")
    Long getMaxId();

}

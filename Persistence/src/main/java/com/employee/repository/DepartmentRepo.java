package com.employee.repository;

import com.employee.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepo extends JpaRepository<Department,Long> {

    @Query("SELECT coalesce(max(dept.id), 0) FROM Department dept")
    Long getMaxId();
}



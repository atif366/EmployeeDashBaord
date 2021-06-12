package com.employee.repository;


import com.employee.entity.ServiceUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DashBoardUserServiceRepository extends JpaRepository<ServiceUser, Integer> {
	
	public Optional<ServiceUser> findByUserName(String username);
}

package com.employee.config.security;

import com.employee.entity.ServiceUser;
import com.employee.repository.DashBoardUserServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DashBoardUserServiceImpl implements DashBoardUserService {

	@Autowired
	DashBoardUserServiceRepository repo;
	
	@Override
	public ServiceUser findUser(String userId) throws Exception {
		Optional<ServiceUser> findByUserName = repo.findByUserName(userId);
		return findByUserName.orElse(null);
	}

}

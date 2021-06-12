package com.employee.config.security;


import com.employee.entity.ServiceUser;
import com.employee.exception.UserNameNotFOundException;

public interface DashBoardUserService {
	
	ServiceUser findUser(String userId) throws UserNameNotFOundException, Exception;

}

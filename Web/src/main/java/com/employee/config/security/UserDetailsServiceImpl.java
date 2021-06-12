package com.employee.config.security;

import com.employee.entity.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	

	DashBoardUserService dashBoardUserService;

	@Autowired
	public UserDetailsServiceImpl(DashBoardUserService dashBoardUserService) {
		this.dashBoardUserService = dashBoardUserService;
	}

	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
		ServiceUser findUser = null;
		try {
			findUser = dashBoardUserService.findUser(userName);
		} catch (Exception e) {
			return null;
		}
		if(findUser==null) {
			return null;
		}
		List<GrantedAuthority> grants = new ArrayList<>();
		grants.add(new SimpleGrantedAuthority(findUser.getRole()));
		return new DashBoardUserDetails(findUser.getUserName(), findUser.getPassword(), grants);
	}

}

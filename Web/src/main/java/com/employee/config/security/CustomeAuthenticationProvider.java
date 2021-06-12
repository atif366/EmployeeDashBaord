package com.employee.config.security;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;


@Component
public class CustomeAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	public Authentication authenticate(Authentication auth)  {
		DashBoardUserDetails dashBoardUserDetails;
		if (!validateUser(auth)) {
			throw new BadCredentialsException("UserName/Password Is Invalid");
		}
		dashBoardUserDetails = (DashBoardUserDetails) userDetailsService.loadUserByUsername(auth.getName().toUpperCase());
		 if(!auth.getCredentials().toString().equalsIgnoreCase(dashBoardUserDetails.getPassword())) {
			 throw new BadCredentialsException("Password Is Invalid");
		 }
		 return new UsernamePasswordAuthenticationToken(dashBoardUserDetails, null, dashBoardUserDetails.getAuthorities());
		
	}
	
	public boolean validateUser(Authentication authentication) {
		try {
			String userName = authentication.getName();
			String password = authentication.getCredentials().toString();
			return (StringUtils.isNoneBlank(userName) && StringUtils.isNoneBlank(password));
		} catch (Exception e) {
			return false;
		}
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(clazz);
	}

}

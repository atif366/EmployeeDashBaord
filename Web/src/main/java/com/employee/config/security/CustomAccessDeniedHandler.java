package com.employee.config.security;

import lombok.SneakyThrows;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.naming.AuthenticationException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler  {

	@SneakyThrows
	@Override
	public void handle(HttpServletRequest arg0, HttpServletResponse arg1, AccessDeniedException arg2)
			throws IOException, ServletException {

		System.out.println("Test");
		throw new AuthenticationException(arg2.getMessage());
	}

}

package com.example.app.config.auth.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

public class CustomAuthenticationEntryPoint implements AuthenticationEntryPoint {

	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		System.out.println("CustomAuthenticationEntryPoint's 접근권한이없어요 당신 "+authException);
		
		request.setAttribute("msg", "인증이필요한 페이지입니다.");
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);

	}

}

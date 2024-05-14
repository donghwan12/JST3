package com.example.app.config.auth.LoginHandler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		
		System.out.println("로그인실패 : " + exception);
		
		request.setAttribute("msg", "로그인 실패..ID/PW확인하세요");
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		//로그인실패시 이동할 페이지
//		response.sendRedirect(request.getContextPath()+"/login?error="+exception.getMessage());

	}

}

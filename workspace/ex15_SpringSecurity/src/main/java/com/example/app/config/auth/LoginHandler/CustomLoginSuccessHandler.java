package com.example.app.config.auth.LoginHandler;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CustomLoginSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		log.info("CustomLoginSuccessHandler's onAuthenticationSuccess : "+authentication);	
		Collection<? extends GrantedAuthority> collection=authentication.getAuthorities();
		
		collection.forEach(role->{
			log.info("Role :"+ role.getAuthority());
			String role_str=role.getAuthority();
			
			if(role_str.equals("ROLE_ADMIN")) {
				try {
					response.sendRedirect(request.getContextPath()+"/admin");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return ;
				
			}else if(role_str.equals("ROLE_MEMBER")) {
			
				try {
					response.sendRedirect(request.getContextPath()+"/member");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return ;
			}else if(role_str.equals("ROLE_USER")) {
				try {
					response.sendRedirect(request.getContextPath()+"/user");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return ;
			}
			
		});
	}

}

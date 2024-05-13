package com.example.app.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SecurityTestController {
	
	@GetMapping("/user")
	public void user(Authentication authentication, Model model) {
		log.info("GET/User.. authentication : "+authentication);
		log.info("name: "+authentication.getName());
		log.info("principle :"+authentication.getPrincipal());
		log.info("Authorities : "+authentication.getAuthorities());
		log.info("Details : "+authentication.getDetails());
		log.info("credential : "+authentication.getCredentials());
		
		
//	 Model로전달
		model.addAttribute("name",authentication.getName());
		model.addAttribute("pricipal",authentication.getPrincipal());
		model.addAttribute("isAuthenticated",authentication.isAuthenticated());
	}
	
	@GetMapping("/member")
	public void member(Model model) {
		log.info("GET/member..");
		
		Authentication authentification=SecurityContextHolder.getContext().getAuthentication();
		model.addAttribute("authentification",authentification);
		
	}
	
	@GetMapping("/admin")
	public void admin() {
		log.info("GET/admin..");
	}
}

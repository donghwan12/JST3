package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class SecurityTestController {
	
	@GetMapping("/user")
	public void user() {
		log.info("GET/User..");
	}
	
	@GetMapping("/member")
	public void member() {
		log.info("GET/member..");
	}
	
	@GetMapping("/admin")
	public void admin() {
		log.info("GET/admin..");
	}
}

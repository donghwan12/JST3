package com.example.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.app.domain.dto.PersonDto;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/test")
public class ParameterTestController {
	
	//GET
	//@RequestMapping(value = "/p01" ,method=RequestMethod.GET)
	@GetMapping("/p01")
	public void p1(@RequestParam(required = true) String name) {
		log.info("GET /test/p01..." + name);
	}
	
	@GetMapping("/p02")
	public void p2(@RequestParam(required = false,name="username") String name) {
		log.info("GET /test/p02..." + name);
	}
	
	//POSTMAN TESTS
	//MOCK TESTS
	@RequestMapping(value="/p03",method=RequestMethod.POST)
	public void p3(@RequestParam String username) {
		log.info("POST /test/p03..."+username);
	}
	
	// @RequestParam 	: 동기요청 방식 기본 / form 기반 요청 받기
	// @RequestBody 	: 비동기요청 방식 기본 /  form / json 등 받기
	@RequestMapping(value="/p04",method=RequestMethod.POST)
	public void p4(@RequestBody String username) {
		log.info("POST /test/p04..."+username);
	}
	
	@RequestMapping(value="/p05",method=RequestMethod.GET)
	public void p5(@RequestParam(required=false,defaultValue="홍길동") String username) {
		log.info("GET /test/p05..."+username);
	}
	
	@RequestMapping(value="/p06",method=RequestMethod.GET)
	public void p6(String name, int age , String addr) {
		log.info("GET /test/p06..."+name+" " + age + " " + addr);
	}
	
	@RequestMapping(value="/p07",method=RequestMethod.GET)
	public void p7(PersonDto dto) {
		log.info("GET /test/p07..."+dto);
	}
	
	@RequestMapping(value="/p08/{name}/{age}/{addr}",method=RequestMethod.GET)
	public void p8(@PathVariable String name, 
				@PathVariable	int age , 
				@PathVariable String addr) {
		log.info("GET /test/p08..."+name+" " + age + " " + addr);
	}
	
	@RequestMapping(value="/p09/{name}/{age}/{addr}",method=RequestMethod.GET)
	public void p9(PersonDto dto) {
		log.info("GET /test/p09..."+dto);
	}
	
	@GetMapping("/page1")
	public void page01(Model model) {
		model.addAttribute("TEST1","test1_value");
		log.info("GET/test/page1...");
	}
	
}
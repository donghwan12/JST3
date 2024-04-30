package com.example.app.controller;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml","file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})
@WebAppConfiguration
@Slf4j

public class controllerTests {

	
	@Autowired
	private SimpleController simplecontroller;
	
	private MockMvc mockmvc;
	
	@Autowired
	private WebApplicationContext wac;
	@Before
	public void setup() {
		this.mockmvc=MockMvcBuilders.webAppContextSetup(wac).build();
		
	}
	
	@Test
	public void isNotnulltest() {
		log.info(simplecontroller.toString());
		log.info(mockmvc.toString());
		assertNotNull(simplecontroller);
		assertNotNull(mockmvc);
		
		
	}
	
	@Test
	public void SimpleControllerTests() throws Exception{
		//GET //Simple/t1
//		mockmvc.perform(get("/simple/t1"))
//			.andExpect(status().isOk())
//			.andExpect(view().name("simple/t1"))
//			.andExpect(model().attributeExists("key1"))
//			.andDo(print());
		//POST//Simple/t1
		mockmvc.perform(post("/simple/t1"))
			.andExpect(status().isOk())
			.andDo(print());
		
		//GET/POST //Simple/t2
		mockmvc.perform(post("/simple/t1"))
		.andExpect(status().isOk())
		.andDo(print());
		
		
	}


}

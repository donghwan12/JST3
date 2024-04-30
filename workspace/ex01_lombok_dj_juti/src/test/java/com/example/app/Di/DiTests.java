package com.example.app.Di;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.app.domain.dto.PersonComponent;
import com.example.app.domain.dto.PersonDto;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class DiTests {

	@Autowired
	private PersonDto personDtoByXml; //root-context에 있는 bean 경로
	
	@Autowired
	private PersonDto personDtoByXml2;
	@Autowired
	private PersonDto person03;
	@Autowired
	private PersonDto personDtoBean;
	@Autowired
	private PersonComponent personcomponent;
	
	@Test
	public void test() {
		log.info(personDtoByXml.toString());
		log.info(personDtoByXml2.toString());
		log.info( person03.toString());
		log.info( personDtoBean.toString());
		log.info(personcomponent.toString());
		
	}
	@Autowired
	private ApplicationContext applicationContext;
	
	@Test
	public void BeanTest_02() {
		log.info(applicationContext.toString());
		log.info(personDtoByXml.toString());
		log.info(personDtoByXml2.toString());
		log.info(person03.toString());
		log.info(personDtoBean.toString());
	}

}

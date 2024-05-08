package com.example.app.lombok;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.example.app.domain.dto.PersonDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class lombokTest {

	@Test
	public void personDto() {
		PersonDto ob=new PersonDto();
		ob.setName("홍길동");
		ob.setAddr("대구");
		ob.setAge(32);
		
		log.info(ob.toString());
		//Junit test Funciton...
		assertNotNull(ob);
	}

	@Test
	public void personDtoTest_2() {
		// @Builder
		PersonDto ob=PersonDto.builder()
					.age(22)
					.name("홍길동")
					.addr("대구")
					.build();
		log.info(ob.toString());
		assertNotNull(ob);
		
	}
}

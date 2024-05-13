package com.example.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.app.domain.dto.PersonDto;

@Configuration
public class PersonDtoBeanConfig {
	
	@Bean
	public PersonDto person03() {
		
		return PersonDto.builder()
				.name("철수")
				.addr("서울")
				.age(34)
				.build();
				
	}
	@Bean(name="personDtoBean")
	public PersonDto person04() {
		
		return PersonDto.builder()
				.name("짱구")
				.addr("서울")
				.age(5)
				.build();
				
	}
}

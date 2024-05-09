package com.example.app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Setter
//@Getter
//@ToString

@Data
@NoArgsConstructor //디폴트 생성자
@AllArgsConstructor //모든 요소를 받는 생성자.
@Builder


public class PersonDto {

	private String name;
	private int age;
	private String addr;
}

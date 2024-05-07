package com.example.app.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //디폴트 생성자
@AllArgsConstructor //모든 요소를 받는 생성자.
@Builder
public class BoardDto {

	
	private int id;
	private String title;
	private String contents;
	private String writer;
	private String regDate;
	
}

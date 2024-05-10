package com.example.app.domain.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor //디폴트 생성자
@AllArgsConstructor //모든 요소를 받는 생성자.
@Builder
public class memoDto {
	
	@Min(value=10,message="최소 숫자는 10이상 이어야 합니다.")
	@Max(value=1000,message="최대 숫자는 1000이하 이어야 합니다.")
	@NotNull(message="id를 입력하세요")
	private int id;
	
	@NotBlank(message="text를 입력하세요")
	private String text;
	
//	@NotBlank(message="writer(작성자)를 입력하세요")
//	@Email(message="email 형식으로 작성하세요")
//	private String writer;
//	
//	@Future(message="현재 날짜 기준 이후날짜를 선택하세요")
//	@DateTimeFormat(pattern="yyyy-mm-dd'T'HH:mm:ss")
//	private LocalDateTime regdate;
}

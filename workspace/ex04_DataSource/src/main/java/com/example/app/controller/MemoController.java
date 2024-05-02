package com.example.app.controller;

import java.io.FileNotFoundException;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.dto.memoDto;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/memo")
public class MemoController {
	
//	//파일 부재 예외 오류처리
//	@ExceptionHandler(FileNotFoundException.class)
//	public String fileNotFoundExceptionHandler(Exception error,Model model) {
//		log.info("MemoController's ExceptionHandler... "+error);
//		model.addAttribute("error",error);
//		
//		return "memo/error";
//	}
//	
//	//산술오류가 떳을대 오류 페이지로 넘긴다.
//	@ExceptionHandler(ArithmeticException.class)
//	public String arithmeticException(Exception error,Model model) {
//		log.info("MemoController's ExceptionHandler... "+error);
//		model.addAttribute("error",error);
//		
//		return "memo/error";
//	}
	
	@GetMapping("/add")
	public void add() {
		log.info("GET/MEMO/add...");
	}
	
	//값을 받는 위치
	//유효성 체크하기 위한 메서드 valid maven에서 설치해야함
	@PostMapping(value ="/add")
	public void add_post(@Valid memoDto dto,BindingResult bindingResult,Model model) {
		log.info("GEt/Memo/add  "+dto);
		
		if(bindingResult.hasFieldErrors()) {
			//log.info("Validation Check Eroor: "+bindingResult.getFieldError("id").getDefaultMessage());
			for(FieldError error:bindingResult.getFieldErrors()) {
				log.info("ErrorField: "+error.getField()+"Eroor MSg:"+error.getDefaultMessage());
				model.addAttribute(error.getField(),error.getDefaultMessage());
			}
			
		}
	}
	@GetMapping("/ex_test1")
	public void ex_test1() throws FileNotFoundException{
		log.info("GET/memo/ex_test1...");
		throw new FileNotFoundException("파일이 존재하지 않습니다...");
	}
	//산술오류
	//나눌수없는 수를 입력했을때 오류처리
	@GetMapping("/ex_test2/{num}/{div}")
	public String ex_test2(@PathVariable("num")int num,@PathVariable("div")int div,Model model) throws ArithmeticException{
		log.info("GET/memo/ex_test2..."+(num/div));
		model.addAttribute("result",(num/div));
		return "memo/result";
		
	}
}



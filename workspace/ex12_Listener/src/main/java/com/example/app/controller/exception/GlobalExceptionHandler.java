package com.example.app.controller.exception;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.io.FileNotFoundException;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

	//파일 부재 예외 오류처리
	@ExceptionHandler(FileNotFoundException.class)
	public String fileNotFoundExceptionHandler(Exception error,Model model) {
		log.info("GlobalExceptionHandler's ExceptionHandler... "+error);
		model.addAttribute("error",error);
		
		return "error";
	}
	
	//산술오류가 떳을대 오류 페이지로 넘긴다.
	@ExceptionHandler(ArithmeticException.class)
	public String arithmeticException(Exception error,Model model) {
		log.info("GlobalExceptionHandler's ExceptionHandler... "+error);
		model.addAttribute("error",error);
		
		return "error";
	}
	
	@ExceptionHandler(Exception.class)
	public String allException(Exception error,Model model) {
		log.info("GlobalExceptionHandler's ExceptionHandler... "+error);
		model.addAttribute("error",error);
		
		return "error";
	}
}

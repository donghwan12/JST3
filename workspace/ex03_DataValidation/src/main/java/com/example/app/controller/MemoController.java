package com.example.app.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.app.domain.dto.memoDto;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/memo")
public class MemoController {
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
}


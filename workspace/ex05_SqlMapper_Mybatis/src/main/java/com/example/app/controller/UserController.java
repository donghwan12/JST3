package com.example.app.controller;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringArrayPropertyEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.domain.dto.UserDto;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class UserController {
	
	//바인딩처리
	@InitBinder
	public void dataBinder(WebDataBinder webDataBinder) {
		log.info("UserController's dataBinder.." + webDataBinder);
		//날짜데이터를 바인더해주는듯?
		webDataBinder.registerCustomEditor(LocalDate.class,"birthday",new UserDtoEditor());
		//hoobys2 
		//배열형식으로 바인딩 한다
		webDataBinder.registerCustomEditor(String[].class,new StringArrayPropertyEditor("#"));
	}

	@GetMapping("/join")
	public void join() {
		log.info("GET/join..");
	}
	
	@PostMapping("/join")
	public void join_post(@Valid UserDto dto,BindingResult bindingResult,Model model) {
		log.info("POST/join..."+dto);
		
		//유효성 체크
		if(bindingResult.hasFieldErrors()) {
			//log.info("Validation Check Eroor: "+bindingResult.getFieldError("id").getDefaultMessage());
			for(FieldError error:bindingResult.getFieldErrors()) {
				log.info("ErrorField: "+error.getField()+", EroorMsg:"+error.getDefaultMessage());
				model.addAttribute(error.getField(),error.getDefaultMessage());
			}
			
		}
	}
}


//UserDtoEditor
@Slf4j
class UserDtoEditor extends PropertyEditorSupport{
	
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		log.info("UserDtoEditor..SetAsText: "+text);
		text=text.replaceAll("#", "-");
		
		//birthday가 비어있다면 -> 현재날짜로 전달
		if(text.equals("")) {
			text=LocalDate.now().toString();
		}
		LocalDate date=LocalDate.parse(text,DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		log.info("date: "+date);
		
		setValue(date);
	}
	
}



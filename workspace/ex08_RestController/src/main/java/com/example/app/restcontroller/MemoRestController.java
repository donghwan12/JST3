package com.example.app.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.domain.dto.memoDto;
import com.example.app.domain.service.MemoServiceImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/memo")
public class MemoRestController {

	@Autowired
	private MemoServiceImpl memoServiceImpl;
	
	@GetMapping(value="/add_get")
	public boolean add_get(memoDto memodto) {
		log.info("Get/Memo.. "+memodto);
		boolean isadded=memoServiceImpl.memoRegistration(memodto);
		return isadded;
	}
	
}

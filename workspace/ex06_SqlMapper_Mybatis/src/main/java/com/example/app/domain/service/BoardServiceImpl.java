package com.example.app.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.domain.dto.BoardDto;
import com.example.app.domain.mapper.BoardMapper;

@Service
public class BoardServiceImpl {

	
	@Autowired
	private BoardMapper boardmapper;
	
	public boolean boardRegistration(BoardDto boardto) {
		boardmapper.Insert(boardto);
		return true;
	}
}

package com.example.app.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.domain.dto.memoDto;
import com.example.app.domain.mapper.MemoMapper;

@Service
public class MemoServiceImpl {

//	@Autowired
//	private MemoDaoImpl memoDaoImpl;
//	
//	public boolean memoRegistration(memoDto memodto) {
//		memoDaoImpl.Insert(memodto);
//		
//		return true;
//	}
	
	@Autowired
	private MemoMapper memoMapper;
	
	public boolean memoRegistration(memoDto memodto) {
		memoMapper.Insert(memodto);
		return true;
	}
	
}

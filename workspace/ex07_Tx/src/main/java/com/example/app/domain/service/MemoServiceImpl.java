package com.example.app.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.dto.memoDto;
import com.example.app.domain.mapper.MemoMapper;

import lombok.extern.slf4j.Slf4j;

@Service
// log.info 사용 에노테이션
@Slf4j
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
	
	//어떤경우에 트렌젝션을할거냐
	//오류가 발생했을때
	@Transactional(rollbackFor =Exception.class)
	public void addMemoTx(memoDto memodto) {
		log.info("MemoService addMemoTx() invoke...");
		memoMapper.Insert(memodto); //Rollback x
		memodto.setId(memodto.getId()-1);
		memoMapper.Insert(memodto); //PK중복오류발생
	}
}

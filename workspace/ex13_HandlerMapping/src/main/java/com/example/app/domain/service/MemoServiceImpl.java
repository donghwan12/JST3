package com.example.app.domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.dto.memoDto;
import com.example.app.domain.mapper.MemoMapper;
import com.example.app.listener.MemoAddEvent;

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
	
	@Autowired
	private ApplicationEventPublisher publisher;

	
	public boolean memoRegistration(memoDto memodto) throws Exception {
		memoMapper.Insert(memodto);
		//MemoAdd 이벤트 등록
		publisher.publishEvent(new MemoAddEvent(this,memodto));
		
		return true;
		
	}
	
	//어떤경우에 트렌젝션을할거냐
	//오류가 발생했을때
	@Transactional(rollbackFor =Exception.class)
	public void addMemoTx(memoDto memodto) throws Exception {
		log.info("MemoService addMemoTx() invoke...");
		memoMapper.Insert(memodto); //Rollback x
		memodto.setId(memodto.getId()-1);
		memoMapper.Insert(memodto); //PK중복오류발생
	}
	
	
	@Transactional(rollbackFor =Exception.class)
	public boolean modifiedMemo(memoDto dto) throws Exception {
		memoMapper.Update(dto);
		return true;
	}

	@Transactional(rollbackFor =Exception.class)
	public boolean removeMemo(int id) throws Exception {
		
		memoMapper.Delete(id);
		
		return false;
	}
	@Transactional(rollbackFor =Exception.class)
	public List<memoDto> getAllmemo(memoDto dto) throws Exception{
		
		return memoMapper.GetAllMemo(dto);
		
	}
	
	
}

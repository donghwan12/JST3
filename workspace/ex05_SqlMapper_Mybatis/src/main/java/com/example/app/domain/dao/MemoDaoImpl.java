package com.example.app.domain.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.app.domain.dto.memoDto;



@Repository
public class MemoDaoImpl {

	@Autowired
	private SqlSession sqlSession;
	
	private static String namespace="com.example.app.domai.mapper.MemoMapper.";
	
	public	memoDto Insert(memoDto memodto) {
		sqlSession.insert(namespace+"Insert",memodto);
		return memodto;
	}
}

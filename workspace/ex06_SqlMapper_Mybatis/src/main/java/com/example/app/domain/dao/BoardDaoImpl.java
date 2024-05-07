package com.example.app.domain.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.app.domain.dto.BoardDto;

@Repository
public class BoardDaoImpl {
	
	@Autowired
	private SqlSession sqlsession;
	
	private static String namespace="com.example.app.domain.mapper.BoradMapper.";
	
	public BoardDto insert(BoardDto boarddto) {
		sqlsession.insert(namespace+"Insert",boarddto);
		return boarddto;
	}
}

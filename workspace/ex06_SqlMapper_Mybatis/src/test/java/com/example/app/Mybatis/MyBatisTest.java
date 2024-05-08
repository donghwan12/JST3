package com.example.app.Mybatis;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.app.domain.dto.BoardDto;
import com.example.app.domain.mapper.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class MyBatisTest {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Autowired
	SqlSessionFactory sqlSession;
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void boardTest() {
		
//		System.out.println(sqlSession);
//		boardMapper.Insert(new BoardDto(1,"캐슬","느와르","정연","2024"));
//		boardMapper.Insert(new BoardDto(2,"bb","bb","bb","2010"));
//		boardMapper.Insert(new BoardDto(3,"cc","cc","cc","2014"));
//		boardMapper.Insert(new BoardDto(4,"dd","dd","dd","2000"));
//		boardMapper.Insert(new BoardDto(5,"dd","dd","dd","2000"));
//		boardMapper.Insert(new BoardDto(6,"dd","dd","dd","2000"));
//		boardMapper.Insert(new BoardDto(7,"dd","dd","dd","2000"));
		
//		boardMapper.Update(new BoardDto(3,"신의탑","cc","cc","2014"));
		
//		BoardDto r1=boardMapper.selectOne(3);
//		log.info(r1.toString());
		
		List<BoardDto> list=boardMapper.selectAll();
		for(BoardDto dto:list) {
		log.info(dto.toString());
		}
		
	}
}

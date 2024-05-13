package com.example.app.mybatis;

import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.app.domain.dto.memoDto;
import com.example.app.domain.mapper.MemoMapper;

import lombok.extern.slf4j.Slf4j;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Slf4j
public class MyBatisTests {

	@Autowired
	private SqlSessionFactory sqlSessionFactory;
	
	@Test
	public void SqlSessionFactoryTest() {
		log.info(sqlSessionFactory.toString());
		SqlSession session=sqlSessionFactory.openSession();
		Connection conn=session.getConnection();
		log.info(conn.toString());
		
	}

	@Autowired
	private MemoMapper memoMapper;
	
	@Test
	public void memoMappperTest() throws Exception {
		memoMapper.Insert(new memoDto(123,"texxt"));
		memoMapper.Insert(new memoDto(45,"texxt"));
		memoMapper.Insert(new memoDto(21,"texxt"));
		memoMapper.Insert(new memoDto(87,"texxt"));
		memoMapper.Update(new memoDto(123,"hi"));
		memoMapper.Delete(123);
		
//		memoDto r1=memoMapper.Select(21);
//		log.info(r1.toString());
		
//		List<memoDto>list = memoMapper.SelectAll();
//		for(memoDto dto:list) {
//			log.info(dto.toString());
//		}
//		List<Map<String,Object>> result=memoMapper.SelectAllResultMap();
//		result.forEach(map->{
//			for(String key :map.keySet()) {
//				log.info(key+" :"+map.get(key));
//			}
//		});
	
	}
	@Test
	public void MybaitsTestxml() {
//		memoMapper.InsertXml(new memoDto(234,"hihi"));
//		memoMapper.UpdateXml(new memoDto(45,"동오북파"));
//		memoMapper.DeleteXml(87);
		
//		memoDto dto=memoMapper.SelectXml(45);
//		log.info(dto.toString());
	
//		List<memoDto> list=memoMapper.SelectAllXml();
//		for(memoDto dto:list)
//			log.info(dto.toString());
	}
	
	@Test
	public void SelectkeyTests() throws Exception {
//		memoMapper.Insert(new memoDto(-1,"haha"));
		
		memoDto dto=new memoDto(-1,"DADA");
		memoMapper.Insert(dto);
		log.info(dto.toString());
	}
	
	@Test
	public void DynamicQuerys() {
		//전체 검색
//		Map<String,Object> param=new HashMap();
//		param.put("type", "text");
//		param.put("text", "a");
//		List<Map<String,Object>> result=memoMapper.SelectIf(param);
//		
//		result.forEach(map->{
//			for(String key:map.keySet()) {
//				System.out.println("Key :"+key+"val :"+map.get(key));
//			}
//		});
		
		
		Map<String,Object> param=new HashMap();
		param.put("condition", true);
		param.put("type", "id");
		param.put("id", "4");
		List<Map<String,Object>> result=memoMapper.SelectIf(param);
		
		result.forEach(map->{
			for(String key:map.keySet()) {
				System.out.println("Key : "+key+" val :"+map.get(key));
			}
		});
	}
}

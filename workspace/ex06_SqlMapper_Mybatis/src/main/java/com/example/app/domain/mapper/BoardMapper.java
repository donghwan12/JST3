package com.example.app.domain.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.app.domain.dto.BoardDto;

@Mapper
public interface BoardMapper {

	
	public int Insert(BoardDto boardto);
	public int Update(BoardDto boardto);
	public int delete(BoardDto boardto);
	public BoardDto selectOne(@Param("id") int id);
	List<BoardDto> selectAll();
	
	
}

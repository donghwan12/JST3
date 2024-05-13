package com.example.app.listener;

import org.springframework.context.ApplicationEvent;

import com.example.app.domain.dto.memoDto;

public class MemoAddEvent extends ApplicationEvent{

	private memoDto memodto;
	
	public MemoAddEvent(Object source,memoDto dto) {
		super(source);
		this.memodto=dto;
		
	}

	@Override
	public String toString() {
		return "MemoAddEvent [memodto=" + memodto + ",source ="+ source+ "]";
	}
	
}

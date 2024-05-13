package com.example.app.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;

public class MemoAddEventListener implements ApplicationListener<MemoAddEvent>{

	@Override
	public void onApplicationEvent(MemoAddEvent event) {
		System.out.println("[EVENT] MemoAdd : "+event );
		
	}

}

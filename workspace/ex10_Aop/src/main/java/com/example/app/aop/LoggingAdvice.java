package com.example.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Slf4j
public class LoggingAdvice {

	
	//포인트 컷 표현식
	//execution(* com.example.app.domain.service.SimpleServiceImpl.get1())
	//execution: 메서드 실행
	//*:모든 리턴 타입
	// com.example.app.domain.service.SimpleServiceImpl:실행할 함수 위치
	@Before("execution(* com.example.app.domain.service.SimpleServiceImpl.get1())")
	public void logBefore(JoinPoint joinpoint) {
		
		log.info("[AOP] BEFORE..."+joinpoint);
	}
}

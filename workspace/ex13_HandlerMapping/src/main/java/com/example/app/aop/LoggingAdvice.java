package com.example.app.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
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
	
	@After("execution(* com.example.app.domain.service.SimpleServiceImpl.get2())")
	public void logAfter(JoinPoint joinpoint) {
		log.info("[AOP] After..."+joinpoint.getTarget());
		log.info("[AOP] After...."+joinpoint.getSignature().getName());
	}
//	@Around("execution(* com.example.app.domain.service.SimpleServiceImpl.get3())")
//	public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
//		
//		log.info("[Aop]Around Before"+pjp.getSignature().getName()+"Start...");
//		long start=System.currentTimeMillis();
//		Object result= pjp.proceed();
//		long end=System.currentTimeMillis();
//		log.info("[AOP]TIme.."+(end-start)+"ms");
//		log.info("[AOP]Result.. "+result);
//		log.info("[Aop]Around After..."+pjp.getSignature().getName()+"END...");
//		return result;
//	}
	//service 패키지의 모든 클래스 안의 모든 함수를 받기
	@Around("execution(* com.example.app.domain.service.*.*(..))")
public Object logAllAround2(ProceedingJoinPoint pjp) throws Throwable {
		
		log.info("[Aop]Around Before"+pjp.getSignature().getName()+"Start...");
		long start=System.currentTimeMillis();
		Object result= pjp.proceed();
		long end=System.currentTimeMillis();
		log.info("[AOP]TIme.."+(end-start)+"ms");
		log.info("[AOP]Result.. "+result);
		log.info("[Aop]Around After..."+pjp.getSignature().getName()+"END...");
		return result;
	}
}

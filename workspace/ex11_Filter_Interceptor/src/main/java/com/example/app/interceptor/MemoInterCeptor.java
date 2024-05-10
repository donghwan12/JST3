package com.example.app.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class MemoInterCeptor implements HandlerInterceptor{

	//MemoController로 이동하기 전 처리되는 로직
	//return이 false라면 MemoController로 이동하지 못한다.
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("[MemoInterCeptor] preHandle() invoke...");
		return true;
	}

	//MemoController의 작업이 끝난 이후 처리되는 로직이다.
	//
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("[MemoInterCeptor] postHandle() invoke...");
	}
	
	//View Page랜더링 된 이후 처리되는 로직
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("[MemoInterCeptor] afterCompletion() invoke...");
	}

}

package com.example.app.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.BeanNameUrlHandlerMapping;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.example.app.handler.CostomHandler;
import com.example.app.interceptor.MemoInterCeptor;
import com.example.app.listener.CostomContextRefreshedListener;
import com.example.app.listener.RequestHandledEventListener;

@Configuration
@EnableWebMvc
@ComponentScans({
	@ComponentScan("com.example.app.controller"),
	@ComponentScan("com.example.app.restcontroller")
})
public class WebMvcConfig implements WebMvcConfigurer{

	//MULTIPARTCONFIG
	@Bean
	public MultipartResolver multipartResolver() {
		CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();
		multipartResolver.setMaxUploadSize(20971520); 			//20MB //전체 업로드 허용 사이즈
		multipartResolver.setMaxUploadSizePerFile(20971520); 	//20MB //파일이 여러개 올라갈때 1개당 허용 가능한 업로드
		multipartResolver.setMaxInMemorySize(20971520); 		//20MB //캐시공간
		return multipartResolver;
	}
	
	
	//VIEWRESOLVER
	@Bean
	public ViewResolver viewResolver() {
		//servlcet-context.sml의 viewresolver 객체생성
		InternalResourceViewResolver viewResolver =new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
		
	}
	
	
	//RESOURCES
	//servlet -context.sml의 resources 작성
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	
	//InterCeptor
	@Override
	//MemoController로 가기전에 memointerCeptor이 가로채서 확인한다.
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new MemoInterCeptor()).addPathPatterns("/memo/*");
	}
	
	//Listnere Bean
	@Bean
	public RequestHandledEventListener requestHandledEventListener() {
		return new RequestHandledEventListener();
	}
	
	@Bean
	public CostomContextRefreshedListener costomContextRefreshedListener() {
		
		//
		return new CostomContextRefreshedListener();
	}
	//Handler Mapping
	//01 BeanNameUrlHandlerMapping:  요청 url을 동일한 이름을 가진 bean에 매핑
	@Bean
	BeanNameUrlHandlerMapping BeanNameUrlHandlerMapping() {
		return new BeanNameUrlHandlerMapping();
	}
	@Bean("/custom_01")
	public CostomHandler costomHandler() {
		return new CostomHandler();
	}
	//02SimpleURlHandlerMapping :개발자가 직접 매핑정보를 설정,정적자원에 대한 매핑정보 설정이 기본값으로 설정
	@Bean
	SimpleUrlHandlerMapping simpleUrlHandlerMapping() {
		SimpleUrlHandlerMapping handdlerMapping=new SimpleUrlHandlerMapping();
		Map<String,Object> mapUrl=new HashMap();
		mapUrl.put("/custom02", new CostomHandler());
		handdlerMapping.setUrlMap(mapUrl);
		
			return null;
	}
	
}

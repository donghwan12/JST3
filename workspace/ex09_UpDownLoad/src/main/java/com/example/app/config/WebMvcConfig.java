package com.example.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

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
	
	
	
}

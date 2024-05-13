package com.example.app.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.app.config.auth.PrincipalDetailsService;
import com.example.app.config.auth.LoginHandler.CustomLoginSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private PrincipalDetailsService principalDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//웹요청 처리
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		// view페이지의 vsrf를 가려주는용도?
		
		http.csrf().disable();
		
		http.authorizeRequests()
			.antMatchers("/","/join").permitAll() //권한 부여
			.antMatchers("/user").hasRole("USER")   //Role_user
			.antMatchers("/member").hasRole("MEMBER")   //Role_MEmber
			.antMatchers("/admin").hasRole("ADMIN")   //Role_admin
			.anyRequest().authenticated(); //나머지요청에대해선 인증이필요하다
			
		
		//f로그인 처리
		http.formLogin()
			.loginPage("/login")
			.permitAll()
			.successHandler(new CustomLoginSuccessHandler());
		//로그아웃
		http.logout()
			.logoutUrl("/logout")
			.permitAll();
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//임시 계정 생성
//		auth.inMemoryAuthentication()
//			.withUser("user")
//			.password(passwordEncoder.encode("1234"))
//			.roles("USER");
//		
//		auth.inMemoryAuthentication()
//			.withUser("member")
//			.password(passwordEncoder.encode("1234"))
//			.roles("MEMBER");
//		
//		auth.inMemoryAuthentication()
//			.withUser("admin")
//			.password(passwordEncoder.encode("1234"))
//			.roles("ADMIN");
		
		auth.userDetailsService(principalDetailsService).passwordEncoder(passwordEncoder);
	}
	
	
}

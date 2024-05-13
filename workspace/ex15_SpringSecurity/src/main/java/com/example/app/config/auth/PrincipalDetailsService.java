package com.example.app.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.app.domain.dto.UserDto;
import com.example.app.domain.mapper.UserMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PrincipalDetailsService implements UserDetailsService{

//	db로부터 내용들을 꺼내서 principla 단위로 꺼내는 곳
	
	@Autowired
	private UserMapper usermapper; //db읽기용
	
	@Override //form에서 입력했떤 username
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("PrincipalDetailsService's loadUserByUsername() invoke..username :"+username);
		UserDto userDto=usermapper.SelectOne(username);
		if(userDto==null) {
			throw new UsernameNotFoundException(username);		
		}
		return new PrincipalDetails(userDto) ;
	}

	
}

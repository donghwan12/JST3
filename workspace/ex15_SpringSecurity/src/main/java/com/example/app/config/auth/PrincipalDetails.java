package com.example.app.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.app.domain.dto.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrincipalDetails implements UserDetails {

	private UserDto userdto;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collection =new ArrayList();
		collection.add(new GrantedAuthority() {

			@Override
			public String getAuthority() {
				
				return userdto.getRole();
			}
			
		});
		return collection;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return userdto.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userdto.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}

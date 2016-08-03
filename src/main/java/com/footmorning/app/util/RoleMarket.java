package com.footmorning.app.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class RoleMarket {
	private final List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
	
	public RoleMarket(){
		roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		roles.add(new SimpleGrantedAuthority("ROLE_USER"));
		
	}
	
	public GrantedAuthority getRole(String role_name){
		GrantedAuthority result = null;
		for(GrantedAuthority auth : roles){
			if(auth.getAuthority().equals(role_name)){
				result = auth;
			}
		}
		return result;
	}
}

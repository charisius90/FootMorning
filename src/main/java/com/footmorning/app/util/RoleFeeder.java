package com.footmorning.app.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

@Component
public class RoleFeeder {
	private final List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
	
	// Role 권한 목록
	public static final String ROLE_ADMIN = "ROLE_ADMIN";
	public static final String ROLE_USER = "ROLE_USER";
	public static final String ROLE_USER_BLOCK = "ROLE_USER_BLOCK";
	public static final String ROLE_CLUB = "ROLE_CLUB";
	
	
	public RoleFeeder(){
		roles.add(new SimpleGrantedAuthority(ROLE_ADMIN));
		roles.add(new SimpleGrantedAuthority(ROLE_USER));
		roles.add(new SimpleGrantedAuthority(ROLE_USER_BLOCK));
		roles.add(new SimpleGrantedAuthority(ROLE_CLUB));
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

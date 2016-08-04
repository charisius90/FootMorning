package com.footmorning.app.persistence;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import com.footmorning.app.controller.MemberController;

public class CustomJdbcDaoImpl extends JdbcDaoImpl{
	private static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<UserDetails> users = loadUsersByUsername(username);
		
		if(users.size() == 0){
			logger.debug("UserNotFound");
			throw new UsernameNotFoundException("UsernameNotFound");
		}
		
		
		
		return super.loadUserByUsername(username);
	}

	@Override
	protected List<UserDetails> loadUsersByUsername(String username) {
		// TODO Auto-generated method stub
		return super.loadUsersByUsername(username);
	}

	@Override
	protected List<GrantedAuthority> loadUserAuthorities(String username) {
		// TODO Auto-generated method stub
		return super.loadUserAuthorities(username);
	}
	
}

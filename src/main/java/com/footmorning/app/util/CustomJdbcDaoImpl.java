package com.footmorning.app.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;

import com.footmorning.app.domain.CustomUserDetails;

public class CustomJdbcDaoImpl extends JdbcDaoImpl{
	private static final Logger logger = LoggerFactory.getLogger(CustomJdbcDaoImpl.class);
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		List<UserDetails> users = loadUsersByUsername(username);
		logger.info("loadUserByUsername Called : " + username);
		if(users.size() == 0){
			logger.debug("UserNotFound");
			throw new UsernameNotFoundException("UsernameNotFound -> " + username);
		}
		
		CustomUserDetails user = (CustomUserDetails)users.get(0);
		
		Set<GrantedAuthority> rolesSet = new HashSet<GrantedAuthority>();
		
		if(getEnableAuthorities()){
			rolesSet.addAll(loadUserAuthorities(user.getUsername()));
		}
		
		List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
		
		if(roles.size() == 0){
			logger.debug("User '" + username + "' has no authorities and will be treated ad 'not found'");
			throw new UsernameNotFoundException("UsernameNotFound Auth -> " + username);
		}
		
		return user;
	}

	@Override
	protected List<UserDetails> loadUsersByUsername(String username) {
		// TODO Auto-generated method stub
		logger.info("loadUsersByUsername Called : " + getUsersByUsernameQuery());
		// TEST 코드 시작
		List<UserDetails> list = getJdbcTemplate().query(getUsersByUsernameQuery(), new String[]{username}, new RowMapper<UserDetails>(){
			public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException{
				String username = rs.getString(1);
				String password = rs.getString(2);
				return new CustomUserDetails(username, password);
			}
		});
		
		for(UserDetails user : list){
			System.out.println("id : " + user.getUsername());
			System.out.println("pw : " + user.getPassword());
		}
		// TEST 코드 끝
		
		return getJdbcTemplate().query(getUsersByUsernameQuery(), new String[]{username}, new RowMapper<UserDetails>(){
			public UserDetails mapRow(ResultSet rs, int rowNum) throws SQLException{
				String username = rs.getString(1);
				String password = rs.getString(2);
				return new CustomUserDetails(username, password);
			}
		});
	}

	@Override
	protected List<GrantedAuthority> loadUserAuthorities(String username) {
		// TODO Auto-generated method stub
		logger.info("loadUserAuthorities Called : " + getAuthoritiesByUsernameQuery());
		return getJdbcTemplate().query(getAuthoritiesByUsernameQuery(), new String[]{username}, new RowMapper<GrantedAuthority>(){
			public GrantedAuthority mapRow(ResultSet rs, int rowNum) throws SQLException{
				String role = getRolePrefix() + rs.getString(1);
				return new SimpleGrantedAuthority(role);
			}
		});
	}
	
}

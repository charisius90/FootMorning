package com.footmorning.app.domain;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public class CustomAuthenticationProvider implements AuthenticationProvider {
	private static final Logger logger = LoggerFactory.getLogger(CustomAuthenticationProvider.class);

	@Override
	public boolean supports(Class<?> arg0) {
		return arg0.equals(UsernamePasswordAuthenticationToken.class);
	}

	@Override
	public Authentication authenticate(Authentication arg0) throws AuthenticationException {
		String user_id = (String) arg0.getPrincipal();
		String user_pw = (String) arg0.getCredentials();

		logger.info("Welcome authenticate! {}", user_id + "/" + user_pw);

		// check whether user's credentials are valid.
		// if false, throw new
		// BadCredentialsException(messages.getMessage("AbstractUserDetailsAuthenticationProvider.badCredentials",
		// "Bad credentials"));

		/*
		if (user_pw.equals("1111")) {
			List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
			roles.add(new SimpleGrantedAuthority("ROLE_USER"));

			UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(user_id, user_pw,
					roles);
			result.setDetails(new CustomUserDetails(user_id, user_pw));
			return result;
		} else {
			return null;
		}
		*/
		
		if (user_id.equals("guest") && user_pw.equals("1111")) {
			List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
			roles.add(new SimpleGrantedAuthority("ROLE_USER"));

			UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(user_id, user_pw, roles);
			result.setDetails(new CustomUserDetails(user_id, user_pw));
			return result;
		} 
		else if(user_id.equals("admin") && user_pw.equals("0000")){
			List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
			roles.add(new SimpleGrantedAuthority("ROLE_ADMIN"));

			UsernamePasswordAuthenticationToken result = new UsernamePasswordAuthenticationToken(user_id, user_pw, roles);
			result.setDetails(new CustomUserDetails(user_id, user_pw));
			return result;
		}
		else {
			return null;
		}
	}
}

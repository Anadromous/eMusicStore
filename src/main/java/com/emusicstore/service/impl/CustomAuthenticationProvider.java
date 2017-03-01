package com.emusicstore.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.emusicstore.dao.CustomerDao;
import com.emusicstore.model.Customer;

@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider{
	
	final static Logger log = Logger.getLogger(CustomAuthenticationProvider.class);
			
	@Autowired
	private CustomerDao dao;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) authentication;
		Customer user = dao.getCustomerByUsername(token.getName());

		log.debug(">>>>>>>>>>>>>>>>>>>> CustomAuthenticationProvider user: "+user.toString());
		
		if(!user.getPassword().equalsIgnoreCase(token.getCredentials().toString())) {
			throw new BadCredentialsException("The credentials are invalid");
		}
		
		return new UsernamePasswordAuthenticationToken(user, user.getPassword(), user.getAuthorities());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return UsernamePasswordAuthenticationToken.class.equals(authentication);
	}

}

package com.emusicstore.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.emusicstore.service.CustomerService;

@Component("customUserDetailsService")
public class CustomUserDetailService implements UserDetailsService {
	
	@Autowired
	private CustomerService service;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return service.getCustomerByUsername(username);
	}

}

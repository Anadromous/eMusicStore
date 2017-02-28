package com.emusicstore.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.emusicstore.service.CustomerService;


@Component("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

	final static Logger log = Logger.getLogger(CustomUserDetailsService.class);
	
	@Autowired
	private CustomerService repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		log.debug(">>>>>>>>>>>>>>>>>>>>>>> Getting the customer: "+username);		
		return repo.getCustomerByUsername(username);
	}

}

package com.kirti.portal.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.kirti.portal.entities.CustomerMasters;
import com.kirti.portal.exceptions.ResourceNotFoundException;
import com.kirti.portal.repositories.CustomerMastersRepo;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private CustomerMastersRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//Loading user from database by username	
		CustomerMasters user = this.userRepo.findByEmailId(username).orElseThrow(()->new ResourceNotFoundException("user " ,"Email :", username));
		return user;
	}
	 
	
}
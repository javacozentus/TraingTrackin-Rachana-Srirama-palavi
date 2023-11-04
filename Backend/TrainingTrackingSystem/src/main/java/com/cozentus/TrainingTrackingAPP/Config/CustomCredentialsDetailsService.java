package com.cozentus.TrainingTrackingAPP.Config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.cozentus.TrainingTrackingAPP.model.Credentials;
import com.cozentus.TrainingTrackingAPP.repository.CredentialsRepository;




@Component
public class CustomCredentialsDetailsService implements UserDetailsService {
	
	
	
	@Autowired
	private CredentialsRepository studrep;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Credentials std = studrep.findByUserId(email);

		if (std == null) {
			throw new UsernameNotFoundException("student name not found");
		} else {
			return new CustomeCredentials(std);
		}
	}
	
	
	
	
	

}

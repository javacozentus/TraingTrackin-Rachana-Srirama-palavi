package com.cozentus.TrainingTrackingAPP.Config;

import java.util.Arrays;


import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cozentus.TrainingTrackingAPP.model.Credentials;



public class CustomeCredentials implements UserDetails {
	
	private Credentials std;
	

	public CustomeCredentials(Credentials std) {
		super();
		this.std = std;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority = new SimpleGrantedAuthority(std.getRole());

		return Arrays.asList(authority);
	}

	@Override
	public String getPassword() {
		return std.getPassword();
				
	}

	@Override
	public String getUsername() {
		
		return std.getUserId();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}

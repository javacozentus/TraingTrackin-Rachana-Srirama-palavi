package com.cozentus.TrainingTrackingAPP.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.cozentus.TrainingTrackingAPP.Config.CustomCredentialsDetailsService;

@RestController
@CrossOrigin(allowedHeaders = "*" , origins = "*")
public class CredentialsController {
	
	
	
	@Autowired
	@Qualifier("customCredentialsDetailsService")
	private CustomCredentialsDetailsService customobj;

	@GetMapping("/user")
//	@PreAuthorize("hasRole('USER')")
	public String about() {
		return "user";
	}

	@GetMapping("/admin")
//	@PreAuthorize("hasRole('ADMIN')")
	public String profile() {
		return "admin";
	}

	@GetMapping("/admin/hii")
//	@PreAuthorize("hasRole('ADMIN')")
	public String profile1() {
		return "hii";
	}

	 
	

}

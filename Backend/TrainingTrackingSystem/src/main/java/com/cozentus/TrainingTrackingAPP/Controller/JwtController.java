package com.cozentus.TrainingTrackingAPP.Controller;

import java.security.Principal;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.cozentus.TrainingTrackingAPP.Config.CustomCredentialsDetailsService;
import com.cozentus.TrainingTrackingAPP.helper.JwtUtil;
import com.cozentus.TrainingTrackingAPP.model.JwtModel;
import com.cozentus.TrainingTrackingAPP.model.JwtResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@RestController
@CrossOrigin(allowedHeaders = "*" , origins = "*")
//@CrossOrigin("*")
public class JwtController {
	
	@Autowired
	private AuthenticationManager authenticationmanager;
	
	@Autowired
	@Qualifier("customCredentialsDetailsService")
	private CustomCredentialsDetailsService customobj;
	
	
	@Autowired
	private JwtUtil jwtutilobj;
	
	
	
	@RequestMapping(value="/token", method= RequestMethod.POST)
	public ResponseEntity<?> generateToken(@RequestBody JwtModel jwtmodel) throws Exception{
		
		System.out.println(jwtmodel);
		
		try {
			
			this.authenticationmanager.authenticate(new UsernamePasswordAuthenticationToken(jwtmodel.getUsername(), jwtmodel.getPassword()));
			
		}catch(UsernameNotFoundException e) {
			
			e.getStackTrace();
			throw new Exception("Bed Credentials");
		}
		
		UserDetails userdetails = this.customobj.loadUserByUsername(jwtmodel.getUsername());
	     
		String token = jwtutilobj.generateToken(userdetails);
		
		System.out.println("Token "+token);
		
		return ResponseEntity.ok(new JwtResponse(token));
		
	
	}

	 @GetMapping("/current-user")
	    public UserDetails getCurrentUser(Authentication authentication) {
	        return (UserDetails) authentication.getPrincipal();
	    }
	

	
}

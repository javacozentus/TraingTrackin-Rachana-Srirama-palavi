package com.cozentus.TrainingTrackingAPP.Config;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.cozentus.TrainingTrackingAPP.helper.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	
	@Autowired
	private CustomCredentialsDetailsService customserviceobj;
	
	
	@Autowired
	private JwtUtil jwtutil;
	
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		// get jwt token
		// check is it start from bearer
		// validate
		
		String requesttokenheader = request.getHeader("Authorization");
		String username=null;
		String jwttoken=null;
		
		
		if(requesttokenheader!=null && requesttokenheader.startsWith("Bearer ") ) {
			
			jwttoken = requesttokenheader.substring(7);
			
			try {
				
				username=this.jwtutil.getUsernameFromToken(jwttoken);
				
			}catch(Exception e) {
				e.printStackTrace();
			}
			
			UserDetails userDetails = this.customserviceobj.loadUserByUsername(username);
			if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken  =	new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
				usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				
			}else {
				System.out.println("Token is not validated...");
			}
			
			
		}
		
		
		filterChain.doFilter(request, response);
		
		
	}

	
	}

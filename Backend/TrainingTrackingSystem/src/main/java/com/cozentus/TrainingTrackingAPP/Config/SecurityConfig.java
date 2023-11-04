package com.cozentus.TrainingTrackingAPP.Config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;





@Configuration
@EnableMethodSecurity()
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private JwtAuthenticationFilter jwtfilter;
	
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService getDetailsService() {
		return new CustomCredentialsDetailsService();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(getDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthenticationProvider;
	}
	
//	
//	 @Bean
//	 public SecurityFilterChain securityfilterChain(HttpSecurity http) throws Exception {
//		 
//		http.csrf((csrf)->{
//			csrf.disable();
//		}).cors(cors->cors.disable());
//		 http
//         .authorizeHttpRequests((authz) -> authz
//             .requestMatchers("/admin").hasRole("ADMIN")
//             .requestMatchers("/user").hasRole("USER")
//             .anyRequest().authenticated()
//         );
	
	
	 @Bean
	 public SecurityFilterChain securityfilterChain(HttpSecurity http) throws Exception {
		 
		http.csrf().disable()
		.cors().disable().
		authorizeHttpRequests((auth)->{
			try {
				auth.requestMatchers("/token").permitAll()
                 .requestMatchers("/current-user").permitAll()
				.anyRequest().authenticated().and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		 
//		
		http.addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);
//		 http.httpBasic(withDefaults());
		 return http.build();
	 }

	 
	 
	 @Bean
	 public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
			return config.getAuthenticationManager();
		}
	 
	    
//	 @Bean("customStudentDetailsService")
//		public CustomCredentialsDetailsService customCredentialsDetailsService() {
//		    return new CustomCredentialsDetailsService();
//		}

}
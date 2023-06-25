package com.example.pacs.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.pacs.service.UserInfoDetailService;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfiguration{
	
	
		@Bean
	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	        http
					 .csrf(csrf -> csrf.disable()).cors((cors)->cors.disable()) 
	            .authorizeHttpRequests((authorize) -> authorize
							
							
							 // .requestMatchers("/registration/welcome").hasAuthority("USER")
							  //.requestMatchers("/registration/**").hasAuthority("ADMIN") //this will give unauthorized Access in PostMan!!
							 // .requestMatchers("/registration").hasAuthority("ADMIN")
							  .requestMatchers("/registration/newUser").permitAll() //this will help to send the request from the PostMan
							 
							 
	            		.requestMatchers("/registration/welcome", "/registration/mgr","/registration/admin").hasAnyAuthority("ADMIN") 
	            		.requestMatchers("/registration/emp", "/registration/common").hasAnyAuthority("USER","ADMIN")
	            		
	                .anyRequest().authenticated()
	                
	            ) 
	           // .logout((logout) -> logout.logoutSuccessUrl("/"))
	           
	           // .logout((logout) -> logout.deleteCookies("our-custom-cookie"))
	            
	            .formLogin(withDefaults())
	 			// sample logout customization
	 			.logout((logout) ->
	 				logout.deleteCookies("remove")
	 					.invalidateHttpSession(true)
	 					.clearAuthentication(true)
	 					
					/*
					 * .logoutUrl("/login") .logoutSuccessUrl("/")
					 */
	 			)
					
					/*
					 * .formLogin((formLogin) -> formLogin .usernameParameter("username")
					 * .passwordParameter("password") .loginPage("/signin")
					 * .failureUrl("/authentication/login?failed")
					 * .loginProcessingUrl("/registration"))
					 */
					  
					 
	 			
	            .httpBasic(withDefaults());
	        
	        
	        
	        System.out.println("Inside of filterChain Method!!");
	        
	        return http.build();
	    }
	
	/***Authentication verifies the identity of a user or service, 
	 * And authorization determines their access rights****/		
	//these 2 Method{uses(),passwordEncoder()} help in Authentication!!
		
	    //here We did Authentication{1}!!		
		    @Bean
		    @Description("In memory Userdetails service registered since DB doesn't have user table ")
		    public UserDetailsService userDetailsService() {
		        // The builder will ensure the passwords are encoded before saving in memory
		    	
		    	/*This is hardcoded Stuff for User Access Permission!! */
				/*
				 * UserDetails user = User.builder() .username("Ravish")
				 * .password(encoder.encode("pass")) .roles("USER") .build();
				 * 
				 * UserDetails admin = User.builder() .username("Prince")
				 * .password(encoder.encode("pass1")) .roles("ADMIN") .build();
				 * 
				 * return new InMemoryUserDetailsManager(user, admin);
				 */

		    	return new UserInfoDetailService();
		    }

		    //Note1 =it is not a good Practice to keep Password in a plain Text Need to be encrypted!!
		    @Bean
		    public PasswordEncoder passwordEncoder() {
		        return new BCryptPasswordEncoder();
		    }
		    
		    @Bean							
		    public AuthenticationProvider authenticationProvider() {
		    	DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
		    	authenticationProvider.setUserDetailsService(userDetailsService());
		    	authenticationProvider.setPasswordEncoder(passwordEncoder());
		    	
		    	System.out.println("Inside of authenticationProvider Method!!");
		    	
		    	return authenticationProvider;		 
		    }
	
}
	
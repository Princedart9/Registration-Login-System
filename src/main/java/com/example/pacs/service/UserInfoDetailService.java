package com.example.pacs.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.pacs.config.UserInfoUserDetails;
import com.example.pacs.models.UserInfo;
import com.example.pacs.repository.UserInfoRepository;

@Component
public class UserInfoDetailService implements UserDetailsService {

	@Autowired
	private UserInfoRepository userInfoRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	public UserInfoDetailService() {
		super();
		System.out.println("Inside of UserInfoDetails Service Constructor!!");
	}


	@Override
	public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		UserInfo userInfo = userInfoRepository.findByName(userName);
		if(userInfo==null) {
			System.out.println("failed to get the User Details!!");
		}else {
			System.out.println("Successfully fetched!!");
			System.out.println("login UserName : "+userInfo.getName());
		}
		
		UserInfoUserDetails userInfoDetails=new UserInfoUserDetails(userInfo);
		
		return userInfoDetails;
	}
	

	public String addUser(UserInfo userInfo) {		
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		userInfoRepository.save(userInfo);
		return "success";
	}

}

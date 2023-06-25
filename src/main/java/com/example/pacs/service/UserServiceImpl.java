package com.example.pacs.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.pacs.models.Role;
import com.example.pacs.models.UserDTO;
import com.example.pacs.models.UserInfo;
import com.example.pacs.repository.UserRepository;
import com.example.pacs.web.dto.UserRegistrationDTO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDTO save(UserRegistrationDTO registractionDTO) {
		// TODO Auto-generated method stub
		
		UserDTO userDTO=new UserDTO(registractionDTO.getName(), 
				registractionDTO.getAddress(), registractionDTO.getMobileNo(),
				registractionDTO.getEmailID(),Arrays.asList(new Role("ROLE USER")));
		
		return userRepository.save(userDTO) ;
	}

}

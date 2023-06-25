package com.example.pacs.service;

import com.example.pacs.models.UserDTO;
import com.example.pacs.models.UserInfo;
import com.example.pacs.web.dto.UserRegistrationDTO;

public interface UserService {

	UserDTO save(UserRegistrationDTO registractionDTO);
	
}

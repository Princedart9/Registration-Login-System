package com.example.pacs.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.pacs.models.UserInfo;
import com.example.pacs.service.UserInfoDetailService;
import com.example.pacs.service.UserService;
import com.example.pacs.web.dto.UserRegistrationDTO;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserInfoDetailService userInfoDetailService;

	public UserRegistrationController() {
		super();
	}

	public UserRegistrationController(UserService userService) {
		super();
		this.userService = userService;
	}
	
	//this "user" is passed from the Form!!
	@ModelAttribute("user")
	public UserRegistrationDTO userRegistrationDTO() {
		return new UserRegistrationDTO();
	}
	
	@PostMapping
	public String registerUserAccount(@ModelAttribute("user") UserRegistrationDTO userRegistrationDTO) {
		
		userService.save(userRegistrationDTO);	
		return "redirect:/registration?success";  //redirecting registration Page with success Message!!
	}
	
	//Need to Create handler Method to handle the View!!
	@GetMapping
	public String showRegistration() {
		return "registration";
	}
	
	@GetMapping("/welcome")
	public String showWelcomePage() {
		return "welcome";
	}
	@GetMapping("/admin")
	public String showAdminPage() {
		return "admin";
	}
	@GetMapping("/emp")
	public String showEmpPage() {
		return "employee";
	}
	@GetMapping("/mgr")
	//@PreAuthorize("hasAuthority('USER')")
	public String showMgrPage() {
		return "manager";
	}
	@GetMapping("/common")
	public String showCommonPage() {
		return "common";
	}
	
	@PostMapping("/newUser")
	public String addNewUser(@RequestBody UserInfo userInfo) {
		return userInfoDetailService.addUser(userInfo);
	}

}

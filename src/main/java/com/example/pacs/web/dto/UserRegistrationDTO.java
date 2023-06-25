package com.example.pacs.web.dto;

public class UserRegistrationDTO {
	
	private String name;
	private String address;
	private String mobileNo;
	private String emailID;	
	
	public UserRegistrationDTO() {
	}

	public UserRegistrationDTO(String name, String address, String mobileNo, String emailID) {
		super();
		this.name = name;
		this.address = address;
		this.mobileNo = mobileNo;
		this.emailID = emailID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailID() {
		return emailID;
	}

	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

}

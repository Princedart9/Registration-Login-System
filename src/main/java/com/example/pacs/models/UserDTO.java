package com.example.pacs.models;

import java.util.Collection;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "User")
public class UserDTO {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String name;
	@Column
	private String address;
	@Column
	private String mobileNo;
	@Column
	private String emailID;
	
	//use collection so that 1 user can have Multiple Role!!
	//here Collection is the root[parent] of all java Collection!!
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	//this help to create the 3rd table!!
	@JoinTable(
			name = "user_role",
			joinColumns = @JoinColumn(
					name="user_id", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(
					name="role_id", referencedColumnName = "id"))
	private Collection<Role> roles;

	public UserDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDTO(String name, String address, String mobileNo, String emailID, Collection<Role> roles) {
		super();
		this.name = name;
		this.address = address;
		this.mobileNo = mobileNo;
		this.emailID = emailID;
		this.roles = roles;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}
	
}

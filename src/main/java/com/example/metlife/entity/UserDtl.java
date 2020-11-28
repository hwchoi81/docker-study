package com.example.metlife.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserDtl {

	@Id
	private String UserId;
	private String phone;
	private String address;
	private String email;
	
	public String getUserId() {
		return UserId;
	}
	public void setUserId(String userId) {
		UserId = userId;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}

package com.example.metlife.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	
	@Id
	private String userId;
	private String userName;
	
	@OneToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="user_id", insertable = false)
	private UserDtl userDtl;
	
	public UserDtl getUserDtl() {
		return userDtl;
	}
	public void setUserDtl(UserDtl userDtl) {
		this.userDtl = userDtl;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}

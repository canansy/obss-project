package com.springSecurity.bean;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
	@NotNull
	@Size(min=5,message="At least 5 charachter")
	private String username;
	@NotNull
	@Size(min=10,message="At least  charachter")
	private String fullname;
	
	@NotNull
	private boolean userType;
	
	@NotNull
	private int userID;
	
	@NotNull
	@Size(min=6,message="At least  charachter")
	private String password;
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	public boolean isUserType() {
		return userType;
	}

	public void setUserType(boolean userType) {
		this.userType = userType;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}



}

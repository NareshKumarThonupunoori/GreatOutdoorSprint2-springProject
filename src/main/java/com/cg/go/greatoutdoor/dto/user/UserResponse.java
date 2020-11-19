package com.cg.go.greatoutdoor.dto.user;

import com.cg.go.greatoutdoor.entity.Userdata;

public class UserResponse {
	
	private boolean error;
	private String message;
	private Userdata userDetails;


	public UserResponse(boolean error, String message, Userdata userDetails) {
		this.error = error;
		this.message = message;
		this.userDetails = userDetails;
	}
	
	
	public UserResponse(boolean error, String message) {
		this.error = error;
		this.message = message;
	}
	
	
	public boolean getError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Userdata getUserDetails() {
		return userDetails;
	}
	public void setUserDetails(Userdata userDetails) {
		this.userDetails = userDetails;
	}
	
	
}

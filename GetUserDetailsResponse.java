package com.techm.ms.model;

public class GetUserDetailsResponse {
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	private User user;
	private Status status;

}

package com.techm.ms.service;

import com.techm.ms.model.GetUserDetailsResponse;
import com.techm.ms.model.Status;
import com.techm.ms.model.User;

public interface UserService {
	
	public GetUserDetailsResponse getUserById(int id);
	public Status	createUser(User userDetails);
	

}

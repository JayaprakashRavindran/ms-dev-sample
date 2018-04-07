package com.techm.ms.service;

import com.techm.ms.exception.CustomError;
import com.techm.ms.model.User;

import groovyjarjarantlr.collections.List;

public interface UserService {
	
	User findById(String id);
	
	boolean isExistingUser(String id);
	
	void addUser(User user);
	
	void validateUser(User user, java.util.List<CustomError> errorMessages);
	
}

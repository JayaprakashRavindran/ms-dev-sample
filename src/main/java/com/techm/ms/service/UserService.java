package com.techm.ms.service;


import com.techm.ms.model.User;

public interface UserService {
	
	User findById(Long id);
	
	boolean createUser(User user);
	
	
}

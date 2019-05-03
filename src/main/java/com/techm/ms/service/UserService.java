package com.techm.ms.service;

import java.util.List;

import com.techm.ms.model.User;

public interface UserService {
	
	User findById(long id);
		
	User findByName(String name);

	User saveUser(User user);
		
	boolean isUserExist(User user);
				
	List<User> findAllUsers();
		
}

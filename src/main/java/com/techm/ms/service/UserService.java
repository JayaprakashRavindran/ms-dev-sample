package com.techm.ms.service;


import java.util.List;

import com.techm.ms.model.User;

public interface UserService {
	
	User save(User user);
	
	User findById(long id);
	
	User findByName(String name);
	
	List<User> findAll();
	
	boolean isUserExist(User user);
	
	User deleteUser(long userId);	
}

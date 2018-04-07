package com.techm.ms.service;

import com.techm.ms.model.User;

public interface UserService {
	
	/**
	 * @param user
	 */
	public void createUser(User user);
	
	/**
	 * @param id
	 * @return User
	 */
	public User findById(long id);

}

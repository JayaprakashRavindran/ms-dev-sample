package com.techm.ms.service;

import java.util.List;

import com.techm.ms.model.User;

public interface UserService {
	public void createUser(User user);
	public List<User> retrieveAllUsers();
	public User getUser(int id);

}

package com.user.resource.userResource.model;

import java.util.List;

public interface UserResourceTM {
	
	public List<User> getAllUsers();
	public User getUserByName(String name);
	public User getUserById(String id);
	public void addUser(User user);

}

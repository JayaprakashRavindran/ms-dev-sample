package com.user.resource.userResource.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserService implements UserResourceTM {

	List<User> userList = new ArrayList<>();


	@Override
	public List<User> getAllUsers() {
		return userList;
	}

	@Override
	public User getUserByName(String name) {
		for(User u : userList) {
			if(u.getName().equals(name)) {
				return u;
			}
		}
		return null;
		//return userList.stream().filter(x -> x.getName().equals(name)).;
	}

	@Override
	public User getUserById(String id) {
		for(User u : userList) {
			if(u.getId().equals(id)) {
				return u;
			}
		}
		return null;
		//return userList.stream().filter(t -> t.getId().equals(id)).findFirst().get();
	}
	@Override
	public void addUser(User user) {
		userList.add(user);
	}

}

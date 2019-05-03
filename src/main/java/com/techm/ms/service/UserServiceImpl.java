package com.techm.ms.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.techm.ms.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	  
	private static List<User> users = new ArrayList<>();
	
	static {
		users.add(new User(1,"sachin",40,1234));
		users.add(new User(2,"dravid",40,12345));
		users.add(new User(3,"ganguly",40,12346));
	}

	@Override
	public void createUser(User user) {
		users.add(user);
	}
	
	public List<User> retrieveAllUsers() {
		return users;
	}
	
	public User getUser(int id) {
		for(User user : users) {
			if( user.getId() == id) {
				return user;
			}
		}
		
		return null;
	}

}

package com.techm.ms.resource;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.techm.ms.model.User;
import com.techm.ms.service.UserService;

@Controller
public class UserResourceImpl implements UserResource {
	
	@Autowired
	UserService userService;

	@Override
	public void createUser(User user) {
		userService.createUser(user);
	}

	@Override
	public List<User> retrieveAllUsers() {
		return userService.retrieveAllUsers();
	}

	@Override
	public User getUser(int id) {
		return userService.getUser(id);
	}
	
}

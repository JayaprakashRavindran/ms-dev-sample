package com.user.resource.userResource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.user.resource.userResource.errorMsg.errorMsgApp;
import com.user.resource.userResource.model.User;
import com.user.resource.userResource.model.UserService;

@RestController
public class userContorller {
	
	@Autowired
	private UserService userSerImpl;
	
	@RequestMapping(method=RequestMethod.POST, value="/users")
	public ResponseEntity<?> addAUser(@RequestBody User user) {
		System.out.println("step 10");
		User foundUser = userSerImpl.getUserByName(user.getName());
		System.out.println("step 1");
		if(foundUser == null) {
			System.out.println("step 2");
			userSerImpl.addUser(user);
			return new ResponseEntity(userSerImpl.getAllUsers(), HttpStatus.CREATED);
		}
		else
			return new ResponseEntity(userSerImpl.getAllUsers(), HttpStatus.CONFLICT);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/users")
	public  List<User> getAllUsers() {
		return userSerImpl.getAllUsers();
	}

	@RequestMapping(method=RequestMethod.GET, value="/users/id/{id}")
	public ResponseEntity<?> getAUserById(@PathVariable String id) {
		User foundUser = userSerImpl.getUserById(id);
		System.out.println("step 11");
		if(foundUser == null) {
			System.out.println("error 2");
			String errMsg = "Account with id "+id+" not found";
			return new ResponseEntity(new errorMsgApp(errMsg), HttpStatus.NOT_FOUND);
		}
		else
			return new ResponseEntity(foundUser, HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/user/name/{name}")
	public User getAUserByName(@PathVariable String name) {
		return userSerImpl.getUserByName(name);
	}

}

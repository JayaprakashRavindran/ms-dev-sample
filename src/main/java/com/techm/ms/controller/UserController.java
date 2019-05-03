package com.techm.ms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.techm.ms.model.User;
import com.techm.ms.service.UserService;

@RestController
@RequestMapping("/service")
public class UserController {

	@Autowired
	UserService userService;
    

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<User> createUser( @RequestBody User request) {
    	ResponseEntity<User> response ;
    	if(userService.createUser(request))
    	{
    		response = new ResponseEntity<User>(HttpStatus.CREATED);
        	
    	}
    	else {
    		response = new ResponseEntity<User>(HttpStatus.CONFLICT);
    	}
    	return response;
    }
    
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public @ResponseBody ResponseEntity<User> getUser( @RequestBody User request) {
    	ResponseEntity<User> response ;
    	User user = userService.findById(request.getId());
    	if(null != user)
    	{
    		response = new ResponseEntity<User>(user,HttpStatus.OK);
        	
    	}
    	else {
    		response = new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    	}
    	return response;
    }
}

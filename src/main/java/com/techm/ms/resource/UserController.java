package com.techm.ms.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;

@RestController
@Api
public class UserController {
	
    @Autowired
	UserResourceImpl us;
	
	@RequestMapping(value = "/create/{id}/{name}/{age}/{accountid}",method = RequestMethod.POST)
	public ResponseEntity<String> addUser(@PathVariable("id") long id, @PathVariable("name") String name,
			@PathVariable("age") int age,@PathVariable("accountid") String accountid)
	{
		int accID = Integer.parseInt(accountid);
		String data = us.CreateUser(id,name,age,accID);
		if(data==null)
		{
			return new ResponseEntity<String>("Unable to create"+ name, HttpStatus.CONFLICT);
		}
		return new ResponseEntity<String>(data,HttpStatus.ACCEPTED);
		
		
	}
	
	@RequestMapping(value = "/get/{id}",method = RequestMethod.GET)
	public ResponseEntity<String> getUser(@PathVariable("id") long id)
	{
		String data = us.GetUser(id);
		if(data==null)
		{
			return new ResponseEntity<String>("Unable to find the user", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<String>(data,HttpStatus.FOUND);
		
		
	}

}

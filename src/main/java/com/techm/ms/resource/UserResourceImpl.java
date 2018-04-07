package com.techm.ms.resource;


import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.techm.ms.model.User;
import com.techm.ms.model.representation.Resource;
import com.techm.ms.service.UserService;

@Controller
public class UserResourceImpl implements UserResource {

	public static final Logger logger = LoggerFactory.getLogger(AccountResourceImpl.class);

	@Autowired
	UserService userService; //Service which will do all data retrieval/manipulation work

	private static String baseUrl = "/user";
	
	private static String getUserUrl = baseUrl+"/getUser/{id}";
	private static String createUserUrl = baseUrl+"/addUser";
	
	

	@Override
	public Response getUser(long id) {
		User user = userService.findById(id);		
		if (user == null) {
			return Response.noContent().build();
		}		
		Link link = Link.fromUri(getUserUrl).rel("self").build();		
		Resource<User> resource = new Resource<>(user);
		return Response.ok(resource).links(link).build();
	}

	@Override
	public Response createUser(User user) {
		
		userService.createUser(user);		
				
		Link link = Link.fromUri(createUserUrl).rel("self").build();		
		Resource<User> resource = new Resource<>(user);
		return Response.ok(resource).links(link).build();
		
	}	
	
}

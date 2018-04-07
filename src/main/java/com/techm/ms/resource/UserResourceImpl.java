package com.techm.ms.resource;

import java.net.URI;

import javax.ws.rs.PathParam;
import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import javax.ws.rs.core.Response.Status;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.techm.ms.resource.UserResource;
import com.techm.ms.service.UserService;
import com.techm.ms.model.User;

@Controller
public class UserResourceImpl implements UserResource {
	public static final Logger logger = LoggerFactory.getLogger(UserResourceImpl.class);

	@Autowired
	UserService userService; //Service which will do all data retrieval/manipulation work

	private static String baseUrl = "accounts/users";

	@Override
	public Response getUser(@PathParam("userId") Long userId) {
		User user = userService.findById(userId);		
		if (user == null) {
			return Response.noContent().build();
		}		
		Link link = Link.fromUri(baseUrl).rel("self").build();		
		return Response.ok(user).links(link).build();
	}	
	
	@Override
	public Response createUser(@RequestBody User user) {
		User userresponse = userService.saveUser(user);	
		if (userresponse == null) {
			return Response.status(Status.CONFLICT).build();	
		}
		return Response.status(Status.CREATED).build();
	}
	
}

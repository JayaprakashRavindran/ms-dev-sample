package com.techm.ms.resource;

import java.util.List;

import javax.ws.rs.core.Link;
import javax.ws.rs.core.Response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import com.techm.ms.model.Account;
import com.techm.ms.model.User;
import com.techm.ms.model.representation.ResourceCollection;
import com.techm.ms.service.UserService;

@Controller
public class UserResourceImpl implements UserResource {
	public static final Logger logger = LoggerFactory.getLogger(AccountResourceImpl.class);

	@Autowired
	UserService userService; //Service which will do all data retrieval/manipulation work

	
	@Override
	public ResponseEntity<User> getUser(String userID) {
		User user = userService.findById(Long.valueOf(userID));
		
		ResponseEntity<User> response = new ResponseEntity<User>(user,HttpStatus.OK);
		return response;
	}

	@Override
	public ResponseEntity<User> createUser(User user) {
		Boolean isCreated = userService.createUser(user);
		ResponseEntity<User> response = new ResponseEntity<User>(user,HttpStatus.CREATED);
    	return response;
	}
	
	/*@Override
	public Response findAllAccounts() {
		List<Account> accounts = accountService.findAllAccounts();		
		if (accounts == null) {
			return Response.noContent().build();
		}		
		Link link = Link.fromUri(baseUrl).rel("self").build();		
		ResourceCollection<Account> resource = new ResourceCollection<>(accounts);
		return Response.ok(resource).links(link).build();
	}	*/
	
}

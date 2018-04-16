package com.techm.ms.resource;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.techm.ms.model.User;
import com.techm.ms.service.UserService;

@RestController
public class UserResourceImpl implements UserResource {
	private static final Logger logger = LoggerFactory.getLogger(UserResourceImpl.class); 
	
	private static final String alreadyExists = "Unable to create. A account with the name already exists.";
	private static final String idDoesNotExist = "Account with id ";
	private static final String notFound = " not found";
	private static final String noUsersFound = "There are no users.";
	
	@Autowired
	private UserService userService;
	
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override	
	@PostMapping(path="/users")
	public ResponseEntity<User> createUser(@RequestBody User user){
		logger.debug("Inside createUser");
		if(userService.findByName(user.getName()) != null){
			 return new ResponseEntity(alreadyExists, HttpStatus.CONFLICT);
		}
		userService.save(user);
		return new ResponseEntity<User>(HttpStatus.CREATED);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(path = "/users/{id}")
	public ResponseEntity<User> getUser(@PathVariable long id){
		User user = userService.findById(id);
		if(user == null){
			StringBuilder sb = new StringBuilder();
			sb.append(idDoesNotExist).append(id).append(notFound);
			return new ResponseEntity(sb, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<User>(user, HttpStatus.FOUND);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@GetMapping(path = "/users")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> userList = userService.findAll();	
		if(userList == null){			
			return new ResponseEntity(noUsersFound, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<User>>(userList, HttpStatus.FOUND);
	}

	@DeleteMapping(path = "/users/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable long id) {
		User deletedUser = userService.deleteUser(id);	
		return new ResponseEntity<User>(deletedUser, HttpStatus.OK);
	}
	
	
}

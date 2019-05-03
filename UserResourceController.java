package com.techm.ms.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techm.ms.model.GetUserDetailsResponse;
import com.techm.ms.model.Status;
import com.techm.ms.model.User;
import com.techm.ms.service.UserService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller
public class UserResourceController {
	//Adding request mapping for get User and create User
	@Autowired
	UserService userservice;
	
	@RequestMapping(value="/getUser")
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@ApiOperation(
			value = "Get Account Resource",
			notes = "Returns all the accounts in ResourceCollection representation format",
			response = User.class)
	@ApiResponses(
			value = {
					@ApiResponse(code = 200, message = "OK"),
					@ApiResponse(code = 204, message = "No Content")					
					})
	public ResponseEntity<GetUserDetailsResponse> getUser(int userId){
		
		GetUserDetailsResponse getUserDetails=userservice.getUserById(userId);		 
		return ResponseEntity.ok().body(getUserDetails);
	}
	
	@RequestMapping(value="/createUser")
	@POST
	@Produces({MediaType.APPLICATION_JSON})	
	@Consumes({MediaType.APPLICATION_JSON})
	@ApiOperation(
			value="Status",response = Status.class)
	@ApiResponses(
			value = {
					@ApiResponse(code = 200, message = "OK"),
					@ApiResponse(code = 204, message = "No Content")					
					})
	public ResponseEntity<Status> addUser(User userDetails) {
		
		// TODO Auto-generated method stub
		Status status=userservice.createUser(userDetails);		 
		return ResponseEntity.ok().body(status);
	}
}

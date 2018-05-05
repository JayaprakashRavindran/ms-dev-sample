package com.techm.ms.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.techm.ms.model.User;
import com.techm.ms.model.swagger.UserResponse;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This is the Interface definition for User Resource
 * 
 */

@Api("user")
@Path("/user")
@Produces({MediaType.APPLICATION_JSON})
public interface UserResource {
	
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@ApiOperation(
			value = "Create User Resource",
			notes = "Creates User resource from given user details in json",
			response = UserResponse.class)
	@ApiResponses(
			value = {
					@ApiResponse(code = 201, message = "User Created"),
					@ApiResponse(code = 409, message = "User with that name already exists")
					})
	public void createUser(@RequestBody User user);
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_JSON})
	@ApiOperation(
			value = "Gets a User Resource",
			response = UserResponse.class)
	@ApiResponses(
			value = {
					@ApiResponse(code = 200, message = "Retrieved User")
					})
	public User getUser(@PathVariable int id);
	
}
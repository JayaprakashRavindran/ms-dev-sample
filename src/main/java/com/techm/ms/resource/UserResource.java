package com.techm.ms.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.springframework.http.ResponseEntity;
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
 * @author Kavita Gupta  
 */
@Api("user")
@Path("/users")
@Produces({MediaType.APPLICATION_JSON})
public interface UserResource {
	/**
     * Service definition which creates a user
     * @return ResponseEntity - Returns 201 created when user created and the location where it is created.
     * 
     */	
	@POST	
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@ApiOperation(
			value = "Post User Model Data",
			notes = "Creates a User with the given data in the request body.",
			response = UserResponse.class)
	@ApiResponses(
			value = {
					@ApiResponse(code = 201, message = "Created"),
					@ApiResponse(code = 409, message = "Conflicted")					
					})
	ResponseEntity<User> createUser(@RequestBody User user);
	
	@GET	
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@ApiOperation(
			value = "Get User Resource",
			notes = "Returns the user with the given id in the response.",
			response = UserResponse.class)
	@ApiResponses(
			value = {
					@ApiResponse(code = 301, message = "Found"),
					@ApiResponse(code = 404, message = "Not found")					
					})	
	ResponseEntity<User> getUser(@PathVariable long userId);	
	
	@GET	
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@ApiOperation(
			value = "Get User Resource",
			notes = "Returns all the users in the response.",
			response = UserResponse.class)
	@ApiResponses(
			value = {
					@ApiResponse(code = 301, message = "Found"),
					@ApiResponse(code = 404, message = "Not found")					
					})	
	ResponseEntity<List<User>> getAllUsers();
	
	@DELETE	
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@ApiOperation(
			value = "Delete User Resource",
			notes = "Deletes the user with the given id.",
			response = UserResponse.class)
	@ApiResponses(
			value = {
					@ApiResponse(code = 200, message = "Success"),
					@ApiResponse(code = 404, message = "Not found")					
					})	
	
	ResponseEntity<User> deleteUser(@PathVariable long userId);
	
}
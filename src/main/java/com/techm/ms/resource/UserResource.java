package com.techm.ms.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.techm.ms.model.User;
import com.techm.ms.model.swagger.AccountResponse;
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
	
	 /**
     * Service definition which creates a new user
     * @return User - Returns the 
     * */
	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@ApiOperation(
			value = "Create User Resource",
			notes = "Creates a new user",
			response = UserResponse.class)
	@ApiResponses(
			value = {
					@ApiResponse(code = 201, message = "OK"),
					@ApiResponse(code = 409, message = "Unable to Create")					
					})
	public Response createUser(User user);
	
	/**
     * Service definition which returns a User
     * @return User - Returns the details of the User
     */
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@ApiOperation(
			value = "Get User Resource",
			notes = "Returns User ResourceCollection representation format",
			response = AccountResponse.class)
	@ApiResponses(
			value = {
					@ApiResponse(code = 200, message = "OK"),
					@ApiResponse(code = 404, message = "User not found for the given Id")					
					})
	public Response getUser(long id);
}
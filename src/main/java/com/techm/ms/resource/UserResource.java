package com.techm.ms.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.web.bind.annotation.RequestBody;

import com.techm.ms.model.User;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * This is the Interface definition for User Resource
 * 
 */

@Api("user")
@Path("/api/accounts")
@Produces({MediaType.APPLICATION_JSON})
public interface UserResource {
	   /**
     * Service definition which returns the requested user
     * @return User - Returns the details of the accounts being searched
     */
	@GET
	@Path("~/user/{userId}")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@ApiOperation(
			value = "Get User Resource",
			notes = "Returns the requested user in User representation format",
			response = User.class)
	@ApiResponses(
			value = {
					@ApiResponse(code = 200, message = "OK"),
					@ApiResponse(code = 404, message = "Accunt with requested Id not found")					
					})
	public Response getUser(@PathParam("userId") Long userId);
	
	   /**
  * Service definition which returns the requested user
  * @return User - Returns the details of the accounts being searched
  */
	@POST
	@Path("~/user")
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes({MediaType.APPLICATION_JSON})
	@ApiOperation(
			value = "Create User Resource",
			notes = "Posts user in User representation format")
	@ApiResponses(
			value = {
					@ApiResponse(code = 201, message = "OK"),
					@ApiResponse(code = 409, message = "Unable to create. A Account with name already exist")					
					})
	public Response createUser(@RequestBody User user);

}
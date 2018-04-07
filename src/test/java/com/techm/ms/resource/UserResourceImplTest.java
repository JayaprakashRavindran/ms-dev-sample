package com.techm.ms.resource;

import static org.junit.Assert.assertTrue;

import java.net.InetAddress;
import java.util.UUID;

import javax.ws.rs.core.Response;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.techm.ms.model.User;
import com.techm.ms.service.UserService;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest
public class UserResourceImplTest {
	
	@Autowired
	UserResourceImpl userResourceImpl;
	
	@Autowired
	UserService userService;
	
	
	
	@Test
	public void createUser_fail() {
		User user = new User();
		user.setId(123);
		user.setAge(12);
		
		Response response = userResourceImpl.createUser(user);
		assertTrue(response.getStatus() == 400);
	}
	
	@Test
	public void createUser_failure_conflict() {
		User user = new User();
		user.setId(456);
		user.setAge(12);
		user.setName("name");
		user.setAccountId(456);
		
		User user1 = new User();
		user1.setId(456);
		user1.setAge(21);
		user1.setName("name");
		user1.setAccountId(456);
		
		Response response1 = userResourceImpl.createUser(user);
		Response response2 = userResourceImpl.createUser(user1);
		
		assertTrue(response1.getStatus() == 201);
		assertTrue(response2.getStatus() == 409);
	}
	
	@Test
	public void createUser_success() {
		User user = new User();
		user.setId(123);
		user.setAge(12);
		user.setName("name");
		user.setAccountId(123);
		
		Response response = userResourceImpl.createUser(user);
		assertTrue(response.getStatus() == 201);
	}
	
	@Test
	public void getUser_success() {
		User user = new User();
		user.setId(234);
		user.setAge(12);
		user.setName("name");
		user.setAccountId(234);
		
		userResourceImpl.createUser(user);
		Response userResponse = userResourceImpl.findUserById("234");
		assertTrue(((User)userResponse.getEntity()).getId() == 234L);
	}
	
	@Test
	public void getUser_failure() {
		Response userResponse = userResourceImpl.findUserById("999");
		assertTrue(userResponse.getStatus() == 404);
	}
}

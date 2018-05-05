package com.techm.ms.component;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.util.ReflectionTestUtils;

import com.techm.ms.resource.UserController;
import com.techm.ms.resource.UserResourceImpl;

public class UserTest {
	
	@InjectMocks
	public UserController uc;
	
	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void NoaddUserifExists() {
		UserResourceImpl uri = new UserResourceImpl();
		ReflectionTestUtils.setField(uc,"us",uri);
		ResponseEntity<String> r = uc.addUser(1214,"ritu",25,1001);
		assertEquals(r.getStatusCode(),HttpStatus.ACCEPTED);
	}
	
	@Test
	public void addUserifNotExists() {
		UserResourceImpl uri = new UserResourceImpl();
		ReflectionTestUtils.setField(uc,"us",uri);
		ResponseEntity<String> r = uc.addUser(1214,"rituraj",25,1001);
		assertEquals(r.getStatusCode(),HttpStatus.CONFLICT);
	}
	
	@Test
	public void getUserifExists() {
		UserResourceImpl uri = new UserResourceImpl();
		ReflectionTestUtils.setField(uc,"us",uri);
		ResponseEntity<String> r = uc.getUser(1214);
		assertEquals(r.getStatusCode(),HttpStatus.FOUND);
	}
	
	@Test
	public void getUserifNotExists() {
		UserResourceImpl uri = new UserResourceImpl();
		ReflectionTestUtils.setField(uc,"us",uri);
		ResponseEntity<String> r = uc.getUser(1219);
		assertEquals(r.getStatusCode(),HttpStatus.NOT_FOUND);
	}
	
	

}

package com.techm.ms.component;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import com.techm.ms.model.User;
import com.techm.ms.resource.UserResourceImpl;
import com.techm.ms.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;

@RunWith(SpringRunner.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserResourceComponentTest {
	@Mock
	private UserService mockUserService;

	@InjectMocks
	private UserResourceImpl userResource;	
	
	@Mock
	private MockHttpServletRequest request;
	
	@Before
	public void setup() {		
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testGetUser_success() {
		//Expected
		User expectedUser = new User(4, "Adam", 23, 1);		
		
		//When
		doReturn(expectedUser).when(mockUserService).findById(4);
		
		//method call
		ResponseEntity<User> responseEntity = userResource.getUser(4);
		
		//then
		assertEquals(HttpStatus.FOUND, responseEntity.getStatusCode());		
	}	
	
	@Test
	public void testGetUser_failure() {
		//Expected
		User expectedUser = null;		
		
		//When
		doReturn(expectedUser).when(mockUserService).findById(500);
		
		//method call
		ResponseEntity<User> responseEntity = userResource.getUser(500);
		
		//then
		assertEquals(HttpStatus.NOT_FOUND, responseEntity.getStatusCode());		
	}	
	
	@Test
	public void testCreateUser_success() {		
		User givenUser = new User(0, "James", 23, 3);
		//Expected
		User expectedUser = new User(3, "James", 23, 3);
		
		ResponseEntity<User> expectedResponse = new ResponseEntity<>(HttpStatus.CREATED);
		
		//When
		doReturn(null).when(mockUserService).findByName(givenUser.getName());
		doReturn(expectedUser).when(mockUserService).save(givenUser);		
		
		//method call
		ResponseEntity<User> actualResponse = userResource.createUser(givenUser);
		
		//then
		assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());		
	}	
	
	@Test
	public void testCreateUser_failure() {		
		User givenUser = new User(0, "Adam", 23, 3);
		//Expected
		User existingUser = new User(1, "Adam", 23, 3);
		
		ResponseEntity<User> expectedResponse = new ResponseEntity<>(HttpStatus.CONFLICT);
		
		//When
		doReturn(existingUser).when(mockUserService).findByName(givenUser.getName());			
		
		//method call
		ResponseEntity<User> actualResponse = userResource.createUser(givenUser);
		
		//then
		assertEquals(expectedResponse.getStatusCode(), actualResponse.getStatusCode());		
	}	
}

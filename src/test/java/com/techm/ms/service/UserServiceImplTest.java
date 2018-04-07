/**
 * 
 */
package com.techm.ms.service;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.techm.ms.model.User;

/**
 * @author Murtuza
 *
 */
public class UserServiceImplTest {
	
	static UserService userService;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		userService = new UserServiceImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link com.techm.ms.service.UserServiceImpl#createUser(com.techm.ms.model.User)}.
	 */
	@Test
	public void testCreateUser() {
		User user4 = new User(4,"User4", 20, 4);
		userService.createUser(user4);
	}

	/**
	 * Test method for {@link com.techm.ms.service.UserServiceImpl#findById(long)}.
	 */
	@Test
	public void testFindById3() {
		long id = 3;
		User user = userService.findById(id);
		assertEquals(user.getId(), 3);
	}
	
	

}

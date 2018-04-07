package com.techm.ms.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringRunner;

import com.techm.ms.model.User;

import junit.framework.Assert;

@RunWith(SpringRunner.class)
public class UserServiceImplTest {

	@InjectMocks
	public UserServiceImpl test;
	
	@Test
	public void testFindById() {
		User user = test.findById(1);
		Assert.assertNotNull(user);
	}
	
}

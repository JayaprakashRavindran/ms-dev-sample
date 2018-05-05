package com.techm.ms.helper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.techm.ms.model.Status;
import com.techm.ms.model.User;

@Component
public class UserHelper {
	
	public List<User> getAllUsers()
	{
		List<User> userList = new ArrayList();
		User user1= new User();
		user1.setAccountId(12345);
		user1.setName("xyz");
		user1.setAge(25);
		user1.setId(56789);
		userList.add(user1);
		
		User user2= new User();
		user2.setAccountId(12345);
		user2.setName("abc");
		user2.setAge(35);
		user2.setId(12345);
		userList.add(user2);
		
		User user3= new User();
		user3.setAccountId(12345);
		user3.setName("rty");
		user3.setAge(32);
		user3.setId(23456);
		userList.add(user3);
		
		return userList;
	}

	
	public Status addUser(User userDet)
	{
		//logic to check if user is already present in list
		Status status= new Status();
		List<User> userList =getAllUsers();
		
		userList.forEach(user->{			
			if(user.getAccountId()==userDet.getAccountId())
			{
				status.setStatusCode("409 conflicted");
				status.setStatusMessage("User already exists");				
			}			
			else {
			//add logic to update the userList
				List<User> userListNew =getAllUsers();	
				userListNew.add(user);
				status.setStatusCode("200 OK");
				status.setStatusMessage("User already exists");	
			}
		});		
		
		return status;
	}
	
	
}

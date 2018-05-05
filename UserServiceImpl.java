package com.techm.ms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.techm.ms.helper.UserHelper;
import com.techm.ms.model.GetUserDetailsResponse;
import com.techm.ms.model.Status;
import com.techm.ms.model.User;

@Component
public class UserServiceImpl implements UserService{

	@Autowired
	UserHelper helper;

	public GetUserDetailsResponse getUserById(int id) {
		
		GetUserDetailsResponse getUserDet = new GetUserDetailsResponse();		
		List<User> userList= helper.getAllUsers();		
		userList.forEach(user->{
			User userobj = new User();
			Status status= new Status();
			if(user.getAccountId()== id)
			{
				userobj.setAccountId(user.getAccountId());
				userobj.setAge(user.getAge());
				userobj.setId(user.getId());
				userobj.setName(user.getName());
				getUserDet.setUser(userobj);
			}
			else
			{
				status.setStatusCode("404");
				status.setStatusMessage("NOT FOUND");
				getUserDet.setStatus(status);
			}
		});

		return getUserDet;

	}

	public Status createUser(User userDetails)
	{

		Status status = new Status();
		status=helper.addUser(userDetails);

		return status;
	}

}

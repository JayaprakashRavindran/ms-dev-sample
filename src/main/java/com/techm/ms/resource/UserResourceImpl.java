package com.techm.ms.resource;

import java.util.List;

import org.springframework.stereotype.Component;

import com.techm.ms.model.User;

@Component
public class UserResourceImpl implements UserResource {

	
	public static List<User> list;
	
	static {
		//User u = new User(1, "rituraj",20, 1111);
		
	}
	
	@Override
	public String CreateUser(long id,String name, int age,int accountid) {
		
		for(User user : list) {
			if(user.getName().equals(name)) {
				return null;
			}
		}
		
		User us = new User(id, name, age, accountid);
		
		list.add(us);
		
		return list.toString();
		
	}

	@Override
	public String GetUser(long Id) {
		
		for(User ur : list) {
			if(ur.getId() == Id) {
				return ur.toString();
			}
		}
		return null;
		
		
	}
	
}

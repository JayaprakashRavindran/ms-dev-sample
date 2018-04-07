package com.techm.ms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.techm.ms.model.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<User> users;
	
	
	static {
		users= populateDummyUsers();
	}

	@Override
	public void createUser(User user) {
		counter.incrementAndGet();
		users.add(user);
	}

	@Override
	public User findById(long id) {
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	
	private static List<User> populateDummyUsers(){
		List<User> users = new ArrayList<User>();
		users.add(new User(counter.incrementAndGet(),"User1", 20, 1));
		users.add(new User(counter.incrementAndGet(),"User2", 20, 2));
		users.add(new User(counter.incrementAndGet(),"User3", 20, 3));
		return users;
	}


}

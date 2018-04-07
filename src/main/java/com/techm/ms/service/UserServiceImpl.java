package com.techm.ms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import javax.inject.Named;

import org.springframework.stereotype.Service;

import com.techm.ms.model.User;

@Service("userService")
@Named
public class UserServiceImpl implements UserService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static List<User> users;
	
	static {
		users= populateDummyUsers();
	}

	public List<User> findAllUsers() {
		return users;
	}
	
	public User findById(long id) {
		for(User user : users){
			if(user.getId() == id){
				return user;
			}
		}
		return null;
	}
	
	public User findByName(String name) {
		for(User user : users){
			if(user.getName().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	public User saveUser(User user) {
		if(findByName(user.getName())!=null) {
			return null;
		}
		counter.incrementAndGet();
		user.setId(counter.get());
		users.add(user);
		return user;
	}

	public void updateUser(User user) {
		int index = users.indexOf(user);
		users.set(index, user);
	}

	public boolean isUserExist(User user) {
		return findByName(user.getName())!=null;
	}
	
	private static List<User> populateDummyUsers(){
		List<User> users = new ArrayList<User>();
		users.add(new User(counter.incrementAndGet(),"User1", 26, 1));
		users.add(new User(counter.incrementAndGet(),"User2", 24, 2));
		users.add(new User(counter.incrementAndGet(),"User3", 22, 3));
		return users;
	}

}

package com.techm.ms.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.techm.ms.model.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	private static ArrayList<User> userList = new ArrayList<User>();
	private static Integer userCount = 2;
	
	static{
		userList.add(new User(1, "Adam", 23, 1));
		userList.add(new User(2, "Eve", 25, 2));				
	}
	
	public List<User> findAll(){
		return UserServiceImpl.userList;
	}
	
	public User save(User user){
		user.setId(++userCount);
		userList.add(user);
		return user;
	}
	
	public User findById(long id){				
		for(User user:userList){
			if(user.getId() == id){
				return user;
			}
		}
		return null;		
	}
	
	public User deleteUser(long userId){
		logger.debug("Inside deleteUser");
		User user = null;
		Iterator<User> iterator = userList.iterator();
		while(iterator.hasNext()){
			user = iterator.next();
			if(user.getId() == userId){
				logger.debug("Found***");
				iterator.remove();
				return user;				
			}			
		}	
		logger.debug("User: ", user);		
		return null;		
	}

	@Override
	public boolean isUserExist(User user) {
		return findByName(user.getName())!=null;
	}

	public User findByName(String name) {
		for(User user : userList){
			if(user.getName().equalsIgnoreCase(name)){
				return user;
			}
		}
		return null;
	}
	
	
}

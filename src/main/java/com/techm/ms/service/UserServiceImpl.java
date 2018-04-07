package com.techm.ms.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import com.techm.ms.model.Account;
import com.techm.ms.model.User;

@Service("userService")
public class UserServiceImpl implements UserService{
	
	private static final AtomicLong counter = new AtomicLong();
	
	private static Map<Long,User> users;
	
	
	/*static {
		users= populateDummyAccounts();
	}*/

	 public Map<Long, User> findAllUsers() {
		return users;
	}
	
	
		
	private static List<Account> populateDummyAccounts(){
		List<Account> accounts = new ArrayList<Account>();
		accounts.add(new Account(counter.incrementAndGet(),"Account1"));
		accounts.add(new Account(counter.incrementAndGet(),"Account2"));
		accounts.add(new Account(counter.incrementAndGet(),"Account3"));
		return accounts;
	}

	@Override
	public User findById(Long id) {
		return users.get(id);
	}

	@Override
	public boolean createUser(User user) {
		   if (users.containsKey(user.getId())) {
		        return false;
		   } else {
		          users.put(user.getId(), user);
		          return true;
		        }
		     }

}

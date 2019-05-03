package com.techm.ms.model.swagger;

import com.techm.ms.model.User;
import com.techm.ms.model.representation.Resource;

public class UserResponse extends Resource<User>{
	
	/**
     * This constructor sets the content of the User Response 
     * @param content Command line parameters if any
     * 
     */
	public UserResponse(User content) {
		super(content);
	}

    /**
     * This method gets the content of the User Response 
     * @return content of the user Response
     * 
     */
	@Override
	public User getContent() {
		return super.getContent();
	}


}

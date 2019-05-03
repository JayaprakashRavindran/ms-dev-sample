package com.techm.ms.resource;

/**
 * This is the Interface definition for User Resource
 * 
 */
public interface UserResource {
	
	public String CreateUser(long id,String name, int age,int accountid);
	public String GetUser(long Id);
	
}
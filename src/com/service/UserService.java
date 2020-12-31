package com.service;

public interface UserService {
	public String checkUser(String uname,String upass);
	public String checkFlag(String uname);
	public void updateFlag(String uname,int flag);
	public void createCustomer(String uname, String upass, String ucity);
	public void createAdmin(String uname, String upass);
	
}
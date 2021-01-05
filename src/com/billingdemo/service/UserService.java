package com.billingdemo.service;

import com.billingdemo.util.constants;

public interface UserService {
	public constants checkUser(String uname,String upass);
	public String checkFlag(String uname);
	public void updateFlag(String uname,int flag);
	public void createCustomer(String uname, String upass, String ucity);
	public void createAdmin(String uname, String upass);
	
}
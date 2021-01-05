package com.billingdemo.dao;

import java.util.List;

import com.billingdemo.model.UserDTO;

public abstract class UserDAO {
	public abstract int addUser(UserDTO user);
	public abstract int updateUser(UserDTO user);
	public abstract int deleteUser(UserDTO user);
	public abstract UserDTO getUser(int uid);
	public abstract List<UserDTO> getAllUsers();
	public abstract UserDTO getUserByName(String uname);
}

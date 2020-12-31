package com.dao;

import java.util.List;

import com.model.CustomerDTO;



public abstract class CustomerDAO {
	public abstract int addUser(CustomerDTO customer);
	public abstract int updateUser(CustomerDTO customer);
	public abstract int deleteUser(CustomerDTO customer);
	public abstract CustomerDTO  getUser(int uid);
	public abstract List<CustomerDTO> getAllUsers();
	public abstract CustomerDTO getUserByName(String cname);

}

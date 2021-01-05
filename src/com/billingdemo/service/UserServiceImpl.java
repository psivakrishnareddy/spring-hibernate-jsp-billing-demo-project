package com.billingdemo.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billingdemo.dao.CustomerDAO;
import com.billingdemo.dao.RoleDAO;
import com.billingdemo.dao.UserDAO;
import com.billingdemo.model.CustomerDTO;
import com.billingdemo.model.RolesDTO;
import com.billingdemo.model.UserDTO;
import com.billingdemo.util.constants;

import static com.billingdemo.util.constants.*;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {
	
	
	@Autowired
	private UserDAO userDAO;
	
	
	@Autowired
	private CustomerDAO customerDAO;
	
	@Autowired
	private RoleDAO rolesDAO;
	
	@Override
	public constants checkUser(String uname, String upass) {
		UserDTO user = userDAO.getUserByName(uname);
		if(user!=null) {
			if(user.getFlag()==1) {
				return ALREADY_LOGGED;
			}		
		if(upass.equals(user.getUpass())) {
				if(user.getRole().getRid() == 1) {
					return VALID_ADMIN;
				}else {
					
					return VALID_USER;
				}
			}
			else
			{
				return INVALID_USER;
			}
		}else {
			System.out.println("New user..REdirect to Registration");
			return NEW_USER;
		}
		
		
	}

	@Override
	public String checkFlag(String uname) {
		UserDTO user=userDAO.getUserByName(uname);
		if(user!=null) {
			int flag=user.getFlag();
			if(flag==1) {
				return "loggedin";
			}
			else {
				return "notloggedin";
			}
		}
		else {
			return "invaliduser";
		}
	}

	@Override
	public void updateFlag(String uname, int flag) {
		// TODO Auto-generated method stub
		UserDTO user=userDAO.getUserByName(uname);
		if(user!=null) {
			user.setFlag(flag);
			userDAO.updateUser(user);
		}
	}
	@Override
	public void createCustomer(String uname, String upass, String ucity) {
		// TODO Auto-generated method stub
		CustomerDTO customer = new CustomerDTO();
		RolesDTO role = rolesDAO.getRoleById(2);
		
		customer.setRole(role);
		customer.setFlag(0);
		customer.setCustomeraddress(ucity);
		customer.setCustomername(uname);
		customer.setUname(uname);
		customer.setUpass(upass);
		customerDAO.addUser(customer);
		
	}
	@Override
	public void createAdmin(String uname, String upass) {
		// TODO Auto-generated method stub
		
		UserDTO admin = new UserDTO();
		RolesDTO role = rolesDAO.getRoleById(1);
		admin.setFlag(0);
		admin.setUname(uname);
		admin.setUpass(upass);
		admin.setRole(role);
		
		userDAO.addUser(admin);
		
	}
	
}

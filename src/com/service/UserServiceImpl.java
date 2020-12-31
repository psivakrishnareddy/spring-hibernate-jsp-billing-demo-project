package com.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerDAO;
import com.dao.RoleDAO;
import com.dao.UserDAO;
import com.model.CustomerDTO;
import com.model.RolesDTO;
import com.model.UserDTO;

@Service("UserService")
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userdao;
	
	@Autowired
	private CustomerDAO cusdao;
	
	@Autowired
	private RoleDAO rolesdao;
	
	@Override
	public String checkUser(String uname, String upass) {
		UserDTO user = userdao.getUserByName(uname);
		if(user!=null) {
			if(user.getFlag()==1) {
				return "already";
			}		
		if(upass.equals(user.getUpass())) {
				if(user.getRole().getRid() == 1) {
					return "valid-admin";
				}else {
					
					return "valid";
				}
			}
			else
			{
				return "invalid";
			}
		}else {
			System.out.println("New user..REdirect to Registration");
			return "newuser";
		}
		
		
	}

	@Override
	public String checkFlag(String uname) {
		UserDTO user=userdao.getUserByName(uname);
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
		UserDTO user=userdao.getUserByName(uname);
		if(user!=null) {
			user.setFlag(flag);
			userdao.updateUser(user);
		}
	}
	@Override
	public void createCustomer(String uname, String upass, String ucity) {
		// TODO Auto-generated method stub
		CustomerDTO customer = new CustomerDTO();
		RolesDTO role = rolesdao.getRoleById(2);
		
		customer.setRole(role);
		customer.setFlag(0);
		customer.setCustomeraddress(ucity);
		customer.setCustomername(uname);
		customer.setUname(uname);
		customer.setUpass(upass);
		cusdao.addUser(customer);
		
	}
	@Override
	public void createAdmin(String uname, String upass) {
		// TODO Auto-generated method stub
		
		UserDTO admin = new UserDTO();
		RolesDTO role = rolesdao.getRoleById(1);
		admin.setFlag(0);
		admin.setUname(uname);
		admin.setUpass(upass);
		admin.setRole(role);
		
		userdao.addUser(admin);
		
	}
	
}

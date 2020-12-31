package com.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer_master")
public class CustomerDTO extends UserDTO implements Serializable{
//	private Integer customerid;
	
	private String customername;
	private String customeraddress;
	
	
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomeraddress() {
		return customeraddress;
	}
	public void setCustomeraddress(String customeraddress) {
		this.customeraddress = customeraddress;
	}
	@Override
	public String toString() {
		return "CustomerDTO [customername=" + customername + ", customeraddress=" + customeraddress + "]";
	}
	
	
	
}

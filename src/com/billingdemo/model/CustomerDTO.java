package com.billingdemo.model;

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
	
	private String customerName;
	private String customerAddress;
	
	
	public String getCustomername() {
		return customerName;
	}
	public void setCustomername(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomeraddress() {
		return customerAddress;
	}
	public void setCustomeraddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	@Override
	public String toString() {
		return "CustomerDTO [customerName=" + customerName + ", customerAddress=" + customerAddress + "]";
	}
	
	
	
}

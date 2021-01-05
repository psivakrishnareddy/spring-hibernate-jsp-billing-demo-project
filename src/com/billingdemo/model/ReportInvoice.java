package com.billingdemo.model;

import java.sql.Date;

public class ReportInvoice {
private int invNo;
private int customerId;
private Date inv_date;
private float ammount;
private String customerName;
private String customerCity;
public int getInvno() {
	return invNo;
}
public void setInvno(int invNo) {
	this.invNo = invNo;
}
public int getCustomerid() {
	return customerId;
}
public void setCustomerid(int customerId) {
	this.customerId = customerId;
}
public Date getInv_date() {
	return inv_date;
}
public void setInv_date(Date inv_date) {
	this.inv_date = inv_date;
}
public float getAmmount() {
	return ammount;
}
public void setAmmount(float ammount) {
	this.ammount = ammount;
}
public String getCustomername() {
	return customerName;
}
public void setCustomername(String customerName) {
	this.customerName = customerName;
}
public String getCustomercity() {
	return customerCity;
}
public void setCustomercity(String customerCity) {
	this.customerCity = customerCity;
}


}

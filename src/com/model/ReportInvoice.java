package com.model;

import java.sql.Date;

public class ReportInvoice {
private int invno;
private int customerid;
private Date inv_date;
private float ammount;
private String customername;
private String customercity;
public int getInvno() {
	return invno;
}
public void setInvno(int invno) {
	this.invno = invno;
}
public int getCustomerid() {
	return customerid;
}
public void setCustomerid(int customerid) {
	this.customerid = customerid;
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
	return customername;
}
public void setCustomername(String customername) {
	this.customername = customername;
}
public String getCustomercity() {
	return customercity;
}
public void setCustomercity(String customercity) {
	this.customercity = customercity;
}


}

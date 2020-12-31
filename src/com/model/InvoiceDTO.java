package com.model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;


@Entity
@Table(name = "invoice_master")
public class InvoiceDTO implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int invno;
	
	private int customerid;
	
//	@Temporal(TemporalType.DATE)
	@Column(name = "InvoiceDate",nullable = false, length = 10)
	private Date inv_date;
	
	@Column(name = "amount" , nullable = false)
	private float amount = 0;
	
	@OneToMany(mappedBy = "invoice", fetch = FetchType.LAZY)
	@Cascade({org.hibernate.annotations.CascadeType.ALL}) 
	private List<InvoiceTransactionDTO> inv_list = new ArrayList<InvoiceTransactionDTO>();

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

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public List<InvoiceTransactionDTO> getInv_list() {
		return inv_list;
	}

	public void setInv_list(List<InvoiceTransactionDTO> inv_list) {
		this.inv_list = inv_list;
	}

	@Override
	public String toString() {
		return "InvoiceDTO [invno=" + invno + ", customerid=" + customerid + ", inv_date=" + inv_date + ", amount="
				+ amount + ", inv_list=" + inv_list + "]";
	}


}

package com.model;

	

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "inv_transaction")
public class InvoiceTransactionDTO  implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transid;
	
	@ManyToOne
	@JoinColumn(name = "invno")
	private InvoiceDTO invoice;
	
	@ManyToOne
	@JoinColumn(name = "itemno")
	private ItemDTO item;
	private int qty;
	
	public int getTransid() {
		return transid;
	}
	public void setTransid(int transid) {
		this.transid = transid;
	}


	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}

	public InvoiceDTO getInvoice() {
		return invoice;
	}
	public void setInvoice(InvoiceDTO invoice) {
		this.invoice = invoice;
	}
	public ItemDTO getItem() {
		return item;
	}
	public void setItem(ItemDTO item) {
		this.item = item;
	}
	@Override
	public String toString() {
		return "InvoiceTransactionDTO [transid=" + transid + ", invoice=" + getInvoice().getInvno() + ", item=" + item + ", qty=" + qty
				+ "]";
	}

}
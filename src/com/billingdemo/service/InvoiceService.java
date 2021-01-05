package com.billingdemo.service;

import java.sql.Date;
import java.util.List;

import com.billingdemo.model.CustomerDTO;
import com.billingdemo.model.InvoiceDTO;

public interface InvoiceService {
	public String createInvoice(List<String> citems, String uname, String filepath);
	public String generatePDFBill(InvoiceDTO invoice, CustomerDTO customer, String filepath);
	public void generateCusreports();
	public void getReportsByDate(Date d1, Date d2) throws Exception;
}

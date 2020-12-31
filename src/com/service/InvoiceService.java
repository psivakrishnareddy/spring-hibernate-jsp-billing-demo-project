package com.service;

import java.sql.Date;
import java.util.List;

import com.model.CustomerDTO;
import com.model.InvoiceDTO;

public interface InvoiceService {
	public String createInvoice(List<String> citems, String uname, String filepath);
	public String generatePDFBill(InvoiceDTO invoice, CustomerDTO customer, String filepath);
	public void generateCusreports();
	public void getreportsByDate(Date d1, Date d2) throws Exception;
}

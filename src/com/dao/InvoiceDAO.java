package com.dao;

import java.sql.Date;
import java.util.List;

import com.model.InvoiceDTO;
import com.model.ReportInvoice;

public abstract class InvoiceDAO {
	public abstract void addInvoice(InvoiceDTO invoice);
	public abstract List<ReportInvoice> getReportInvoices();
	public abstract List<ReportInvoice> getReportInvoicesByDates(Date d1 ,Date d2);
	public abstract List<ReportInvoice> getCReportsInvoicesByDates(Date d1 ,Date d2);
}

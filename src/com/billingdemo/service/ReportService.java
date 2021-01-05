package com.billingdemo.service;

import java.sql.Date;

public interface ReportService {
	public  void getReports()throws Exception;
	public  void getReportsByDate(Date d1, Date d2) throws Exception;
}

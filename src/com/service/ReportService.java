package com.service;

import java.sql.Date;

public interface ReportService {
	public  void getReports()throws Exception;
	public  void getreportsByDate(Date d1, Date d2) throws Exception;
}

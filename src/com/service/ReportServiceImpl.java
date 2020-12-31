package com.service;

import java.sql.Date;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;



@Service("ReportService")
@Transactional
public class ReportServiceImpl implements ReportService {
	
	
	@Override
	public void getReports() throws Exception {
		// TODO Auto-generated method stub
		
	}
	@Override
		public void getreportsByDate(Date d1, Date d2) throws Exception {
			// TODO Auto-generated method stub
			
		}
}

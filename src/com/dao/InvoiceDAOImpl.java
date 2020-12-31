package com.dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.HibernateUtility;
import com.model.InvoiceDTO;
import com.model.ReportInvoice;

@Repository("InvoiceDao")
public class InvoiceDAOImpl extends InvoiceDAO{
	@Autowired
	 private HibernateUtility HibUtility;
	@Override
	public void addInvoice(InvoiceDTO invoice) {
		// TODO Auto-generated method stub
		Session session = getHibUtility().currentSession();
		Transaction tx = session.beginTransaction();
		session.save(invoice);
		tx.commit();
	}
	
	@Override
	public List<ReportInvoice> getReportInvoices() {
		// TODO Auto-generated method stub
		
		try {
			Session session = getHibUtility().currentSession();
			String sqlQuery = "select * from invoice_master as inv inner join customer_master as c where inv.customerid = c.uid order by inv.amount desc";
			Query query = session.createSQLQuery(sqlQuery);
			
			List<Object[]> list = query.list();
			Iterator<Object[]> iter = list.iterator();
			List<ReportInvoice> reports = new ArrayList();
			
			if(list.size()!=0) {
				for (Object[] row : list) {   
					   
					ReportInvoice report = new ReportInvoice();
					report.setInvno(Integer.parseInt(row[0].toString()));
					report.setAmmount(Float.parseFloat(row[1].toString()));
					report.setCustomerid(Integer.parseInt(row[2].toString()));
					report.setInv_date(Date.valueOf(row[3].toString()));
					report.setCustomercity(row[4].toString());
					report.setCustomername(row[5].toString());
					
					reports.add(report);
				}
			}
		
			
			return reports;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	
	@Override
	public List<ReportInvoice> getReportInvoicesByDates(Date d1, Date d2) {
		// TODO Auto-generated method stub
		try {
			Session session = getHibUtility().currentSession();
			Query query = session.createSQLQuery("select * from invoice_master as i inner join customer_master as c where c.uid = i.customerid and (i.InvoiceDate between :d1 and :d2) order by i.amount desc;");
			query.setParameter("d1", d1);
			query.setParameter("d2", d2);
			List<Object[]> list = query.list();
			Iterator<Object[]> iter = list.iterator();
			List<ReportInvoice> reports = new ArrayList();
			
			if(list.size()!=0) {
				for (Object[] row : list) {   
					   
					ReportInvoice report = new ReportInvoice();
					report.setInvno(Integer.parseInt(row[0].toString()));
					report.setAmmount(Float.parseFloat(row[1].toString()));
					report.setCustomerid(Integer.parseInt(row[2].toString()));
					report.setInv_date(Date.valueOf(row[3].toString()));
					report.setCustomercity(row[4].toString());
					report.setCustomername(row[5].toString());
					
					reports.add(report);
				}
			}
			
			
			
			
			return reports;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<ReportInvoice> getCReportsInvoicesByDates(Date d1, Date d2) {
		try {
			Session session = getHibUtility().currentSession();
			String sqlQuery = "select i.customerid,c.customername,c.customeraddress, sum(amount) as amount  from invoice_master as i inner join customer_master as c on c.uid = i.customerid where (i.InvoiceDate between :d1 and :d2) group by c.uid order by i.amount desc";
			Query query = session.createSQLQuery(sqlQuery);
			
			
			query.setParameter("d1", d1);
			query.setParameter("d2", d2);
			List<Object[]> list = query.list();
			Iterator<Object[]> iter = list.iterator();
			List<ReportInvoice> reports = new ArrayList();
			
			if(list.size()!=0) {
				for (Object[] row : list) {   
					   
					ReportInvoice report = new ReportInvoice();
//					report.setInvno(Integer.parseInt(row[0].toString()));
					report.setAmmount(Float.parseFloat(row[3].toString()));
					report.setCustomerid(Integer.parseInt(row[0].toString()));
//					report.setInv_date(Date.valueOf(row[3].toString()));
					report.setCustomercity(row[2].toString());
					report.setCustomername(row[1].toString());
					
					reports.add(report);
				}
			}
			
			
			
			return reports;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}
	
	public HibernateUtility getHibUtility() {
		return HibUtility;
	}
	public void setHibUtility(HibernateUtility hibUtility) {
		HibUtility = hibUtility;
	}
}

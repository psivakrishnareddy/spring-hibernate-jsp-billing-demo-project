package com.billingdemo.service;

import java.io.FileOutputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.billingdemo.controller.AppController;
import com.billingdemo.dao.CustomerDAO;
import com.billingdemo.dao.InvoiceDAO;
import com.billingdemo.dao.ItemDAO;
import com.billingdemo.exception.ReportGenerationException;
import com.billingdemo.model.CustomerDTO;
import com.billingdemo.model.InvoiceDTO;
import com.billingdemo.model.InvoiceTransactionDTO;
import com.billingdemo.model.ItemDTO;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;

@Service("InvoiceService")
@Transactional
public class InvoiceServiceImpl implements InvoiceService {
	private static final Logger log = Logger.getLogger(InvoiceServiceImpl.class);

	@Autowired
	private InvoiceDAO invoicedao;
	@Autowired
	private CustomerDAO cusDao;
	
	@Autowired
	private ItemDAO itemdao;
	
	@Override
	public String createInvoice(List<String> citems, String uname, String filepath) {
		// TODO Auto-generated method stub
		CustomerDTO customer = cusDao.getUserByName(uname);
		
		log.info(customer);
		log.info("Customer Items..");
		log.info(citems);
		log.info("user: "+ uname);
		
		InvoiceDTO invoice= new InvoiceDTO();
		invoice.setInv_date(Date.valueOf(LocalDate.now()));
		invoice.setCustomerid(customer.getUid());
		float total =0;
	
		for(String itemqtyno: citems) {
			String ary[] = itemqtyno.split(":");
			
			InvoiceTransactionDTO inv = new InvoiceTransactionDTO();
			ItemDTO item = itemdao.getItem(Integer.parseInt(ary[0]));
			total+= item.getPrice()*Integer.parseInt(ary[1]);
			
			inv.setQty(Integer.parseInt(ary[1]));
			inv.setInvoice(invoice);
			inv.setItem(item);
			
			invoice.getInv_list().add(inv);
		}
		invoice.setAmount(total);
		
		log.info("Creating Invoice..");
		invoicedao.addInvoice(invoice);
		return generatePDFBill(invoice, customer, filepath);
	
	}
	
	@Override
	public String generatePDFBill(InvoiceDTO invoice, CustomerDTO customer , String filepath) {
		// TODO Auto-generated method stub

		try {
			log.info(filepath);
	        Document document = new Document();
	        String invname="invoice" + LocalDate.now() + invoice.getInvno() + ".pdf";
	        String FILE = filepath + invname;
	        
	        PdfWriter.getInstance(document, new FileOutputStream(FILE));
	        document.open();
	        PDFgenerator.addMetaData(document);
	   
	        PDFgenerator.createInvoice(document , invoice , customer);
	        	
	        document.close();
	        log.info("BILL Generated Successfully.... " );
	        return invname;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return null;
		
	}
	@Override
	public void generateCusreports(){
		// TODO Auto-generated method stub
		
		try {
			ReportsGenerator.createExcel(invoicedao.getReportInvoices());
		} catch (Exception e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			
			log.error("Report Generation Failed " + e, new ReportGenerationException());
			throw new ReportGenerationException();
		}
		
	}
	
	@Override
	public void getReportsByDate(Date d1, Date d2) throws Exception {
		// TODO Auto-generated method stub
		 
	//   ReportsGenerator rpg = new ReportsGenerator();
	   ReportsGenerator.createExcel(invoicedao.getReportInvoicesByDates(d1, d2));
	   CReportGenerator.createExcel(invoicedao.getCReportsInvoicesByDates(d1, d2));
		
	}
}

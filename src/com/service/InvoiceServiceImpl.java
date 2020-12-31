package com.service;

import java.io.FileOutputStream;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.CustomerDAO;
import com.dao.InvoiceDAO;
import com.dao.ItemDAO;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.model.CustomerDTO;
import com.model.InvoiceDTO;
import com.model.InvoiceTransactionDTO;
import com.model.ItemDTO;

@Service("InvoiceService")
@Transactional
public class InvoiceServiceImpl implements InvoiceService {

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
		
		System.out.println(customer);
		System.out.println("Customer Items..");
		System.out.println(citems);
		System.out.println("user: "+ uname);
		
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
		
		System.out.println("Creating Invoice..");
		invoicedao.addInvoice(invoice);
		return generatePDFBill(invoice, customer, filepath);
	
	}
	
	@Override
	public String generatePDFBill(InvoiceDTO invoice, CustomerDTO customer , String filepath) {
		// TODO Auto-generated method stub

		try {
			System.out.println(filepath);
	        Document document = new Document();
	        String invname="invoice" + LocalDate.now() + invoice.getInvno() + ".pdf";
	        String FILE = filepath + invname;
	        
	        PdfWriter.getInstance(document, new FileOutputStream(FILE));
	        document.open();
	        PDFgenerator.addMetaData(document);
	   
	        PDFgenerator.createInvoice(document , invoice , customer);
	        	
	        document.close();
	        System.out.println("BILL Generated Successfully.... " );
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
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void getreportsByDate(Date d1, Date d2) throws Exception {
		// TODO Auto-generated method stub
		 
	//   ReportsGenerator rpg = new ReportsGenerator();
	   ReportsGenerator.createExcel(invoicedao.getReportInvoicesByDates(d1, d2));
	   CReportGenerator.createExcel(invoicedao.getCReportsInvoicesByDates(d1, d2));
		
	}
}

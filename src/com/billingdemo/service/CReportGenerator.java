package com.billingdemo.service;

import java.io.FileOutputStream;
import java.time.LocalDate;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.billingdemo.model.ReportInvoice;

public class CReportGenerator {
	 public static void createExcel(List<ReportInvoice> invlist) throws Exception{
		   @SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook();
		     XSSFSheet sheet = workbook.createSheet("Reports");
		   System.out.println(invlist.get(0).getInv_date());
		   int rowCount = 0;
		   int columnCount = 0;
		   
		   CellStyle newCellStyle = workbook.createCellStyle();
		   Font font = workbook.createFont();
		   font.setFontHeightInPoints((short)14);
		   font.setBold(true);
		   
		   
		   Row row1 = sheet.createRow(rowCount);
		   Cell cell1 = row1.createCell(++columnCount);
		   newCellStyle.setFont(font);
		   cell1.setCellStyle(newCellStyle);
	       cell1.setCellValue("CUS ID");
	       cell1 = row1.createCell(++columnCount);
	       cell1.setCellStyle(newCellStyle);
	       cell1.setCellValue("NAME");
	       cell1 = row1.createCell(++columnCount);
	       cell1.setCellStyle(newCellStyle);
	       cell1.setCellValue("CITY");
	       cell1 = row1.createCell(++columnCount);
	       cell1.setCellStyle(newCellStyle);
	       cell1.setCellValue("AMOUNT(rs)");
	       
	       for (ReportInvoice  invoice : invlist) {
	           Row row = sheet.createRow(++rowCount);
	            
	           int cCount = 0;
	           Cell cell = row.createCell(++cCount);
	           cell.setCellValue(invoice.getCustomerid());
	           cell = row.createCell(++cCount);
	           cell.setCellValue(invoice.getCustomername());
	           cell = row.createCell(++cCount);
	           cell.setCellValue(invoice.getCustomercity());
	           cell = row.createCell(++cCount);
	           cell.setCellValue(invoice.getAmmount());

	           }
	           
	          
	            
	       try (FileOutputStream outputStream = new FileOutputStream("C:/Excels/CustomerReports " +LocalDate.now() + ".xls")) {
	           workbook.write(outputStream);
	           System.out.println("Excel Generated");
	       }
	   }
	    
}

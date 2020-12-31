package com.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.model.CustomerDTO;
import com.model.InvoiceDTO;
import com.model.InvoiceTransactionDTO;
import com.model.ItemDTO;



public class PDFgenerator {
	private static Font catFont = new Font(Font.FontFamily.TIMES_ROMAN, 18,
            Font.BOLD);
    private static Font redFont = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.NORMAL, BaseColor.RED);
    private static Font subFont = new Font(Font.FontFamily.TIMES_ROMAN, 16,
            Font.BOLD);
    private static Font smallBold = new Font(Font.FontFamily.TIMES_ROMAN, 12,
            Font.BOLD);
    
    //File Meta Data
    public static void addMetaData(Document document) {
        document.addTitle("invoice");
//        document.addSubject("Converted From XMl");
        document.addAuthor("CODA");
        
    }
    //adding title Page
    public static void createInvoice(Document document ,InvoiceDTO invoice , CustomerDTO customer)
            throws DocumentException {
        Paragraph preface = new Paragraph();
        
       
       Paragraph s = new Paragraph("CODA ONLINE STORE", catFont);
       s.setAlignment(Element.ALIGN_CENTER);
        preface.add(s);
        addEmptyLine(preface, 1); 
        preface.add(new Paragraph(
                "Bill Generated on "  + ", " +  LocalDate.now(), 
                smallBold));
     
        Paragraph invno = new Paragraph( "INVOICE NO: " + invoice.getInvno()  , catFont);
        invno.setAlignment(Element.ALIGN_RIGHT);
        preface.add(invno);
        Paragraph ccus = new Paragraph( "Customer ID:" +Integer.toString(invoice.getCustomerid()) , catFont);
        ccus.setAlignment(Element.ALIGN_RIGHT);
        Paragraph ccun = new Paragraph( "Customer Name: " + customer.getCustomername() , catFont);
        ccun.setAlignment(Element.ALIGN_RIGHT);
        Paragraph ccua = new Paragraph("Customer City: " + customer.getCustomeraddress() , catFont);
        ccua.setAlignment(Element.ALIGN_RIGHT);
        preface.add(ccus);
        preface.add(ccun);
        preface.add(ccua);
         addEmptyLine(preface, 2);
       
        document.add(preface);
        
        Chapter catPart = new Chapter(new Paragraph("Invoice"), 1);
        Paragraph subPara = new Paragraph("Items List", subFont);
        Section subCatPart = catPart.addSection(subPara);
        subCatPart.add(new Paragraph(""));
        Paragraph paragraph = new Paragraph();
//        addEmptyLine(paragraph, 5);
        subCatPart.add(paragraph);
        List<InvoiceTransactionDTO> invitems = invoice.getInv_list();
        // add a table
        
        createTable(subCatPart , invitems , invoice.getAmount());

        // now add all this to the document
        document.add(catPart);
        Paragraph last = new Paragraph( "Thank You For Shoopping.."  , catFont);
        last.setAlignment(Element.ALIGN_RIGHT);
        document.add(last);

        
 
    }
    
    private static void createTable(Section subCatPart ,List<InvoiceTransactionDTO> items, float total)
            throws BadElementException {
        PdfPTable table = new PdfPTable(4);

        // t.setBorderColor(BaseColor.GRAY);
        // t.setPadding(4);
        // t.setSpacing(4);
        // t.setBorderWidth(1);

        PdfPCell c1 = new PdfPCell(new Phrase("ITEM NO"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("ITEM"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);

        c1 = new PdfPCell(new Phrase("PRICE(RS.)xQTY"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
      
        c1 = new PdfPCell(new Phrase("SHOPID"));
        c1.setHorizontalAlignment(Element.ALIGN_CENTER);
        table.addCell(c1);
        table.setHeaderRows(1);
    	Iterator<InvoiceTransactionDTO> iter = items.iterator();
    	System.out.println("You bought..");
    	while(iter.hasNext()) {
    		InvoiceTransactionDTO item = iter.next();
    		
    		 table.addCell(Integer.toString(item.getItem().getItemno()));
    	        table.addCell(item.getItem().getItemname());
    	        table.addCell(Float.toString(item.getItem().getPrice())+ "("+Integer.toString(item.getQty())+")");
//    	        table.addCell(Float.toString(item.getQty()));
    	        table.addCell(Integer.toString(item.getItem().getShopno()));
    	}
//    	table.addCell(" ");
    	table.addCell(" ");
        table.addCell("Total:  ");
        table.addCell(Float.toString(total));
        table.addCell(" ");
       
        subCatPart.add(table);

    }

    
    private static void addEmptyLine(Paragraph paragraph, int number) {
        for (int i = 0; i < number; i++) {
            paragraph.add(new Paragraph(" "));
        }
    }
}

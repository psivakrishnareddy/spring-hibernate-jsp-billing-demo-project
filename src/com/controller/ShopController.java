package com.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.model.ItemDTO;
import com.service.InvoiceService;
import com.service.ItemService;

@Controller
@RequestMapping("/shop")
@ComponentScan("com")
public class ShopController {
	@Autowired
	private ItemService itemservice;
	
	@Autowired
	private InvoiceService InvoiceService;
	
	/*
	 * 
	 * This method Checks if user selected items and redirects to Order or reselct 
	 */
	@RequestMapping(value = "/invoice", method = RequestMethod.POST)
	public String invoiceCreate(HttpSession session) {
		List<Integer>selectitems = (List<Integer>) session.getAttribute("selected-items");
		if(selectitems== null || selectitems.size() == 0) {
			return "comeback";
		}
		System.out.println("invoice page");
		return "invoice";
	}
	
	/*
	 * This method will read Shops Number and Redirects to next page GET METHOD
	 * 
	 */
	
	@RequestMapping(value = "/shop-{shopno}" , method =  RequestMethod.GET )
	public ModelAndView shopGET(ModelAndView mnv, @PathVariable int shopno) {
		System.out.println("Shop1 Loading..");

		List<ItemDTO> items= itemservice.getItemsByShop(shopno);
		mnv.addObject("itemsObj", items);
		
		mnv.setViewName("shop"+shopno);
		return mnv;
	}
	
	/*
	 * This method will read Shops and put the selected items in session POST
	 * 
	 */
	@RequestMapping(value = "/shop-{shopno}" , method =  RequestMethod.POST )
	public ModelAndView shopPOST(ModelAndView mnv, @PathVariable int shopno, HttpServletRequest request, HttpSession session) {
		System.out.println("Shop-"+shopno +" Loading..");

		Enumeration<String> e=request.getParameterNames();
		List<String> selectitems;
		if(session.getAttribute("selected-items")!=null) {
			selectitems = (List<String>) session.getAttribute("selected-items");
		}else {
			selectitems = new ArrayList<String>();
		}
		while(e.hasMoreElements()) {
			
			String name=(String)e.nextElement();
			String value=request.getParameter(name);
//			System.out.println( name +":" + value);
			if(!name.contains("qty")) {
				
				String qty=request.getParameter(value+"-qty");
				System.out.println("qty: " +qty + "item: " + value);
				selectitems.add(value+":"+qty);
			}
		}
		session.setAttribute("selected-items", selectitems);
		
		
	
		List<ItemDTO> items= itemservice.getItemsByShop(shopno);
		mnv.addObject("itemsObj", items);
		
		mnv.setViewName("shop"+shopno);
		return mnv;
	}
	
    /*
     * This methods creates a Order Based on Items Selected, which are present in session
     * 
     */
	@RequestMapping(value = "/order", method = RequestMethod.POST)
	public ModelAndView placeOrder(ModelAndView mnv,HttpSession session, HttpServletRequest request, HttpServletResponse response) {
		List<String>selectitems = (List<String>) session.getAttribute("selected-items");
		System.out.println(selectitems);
		String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/downloads/pdf/");
//		System.out.println(dataDirectory);
		String file = InvoiceService.createInvoice(selectitems, (String)session.getAttribute("uname") ,dataDirectory );
		session.removeAttribute("selected-items");
		mnv.addObject("invoice", file);
		mnv.setViewName("thankyou");
		
		return mnv;
	}
	
	/*
	 * This Route for Downloading Invoice
	 */
	@RequestMapping(value = "/invoice/download", method = RequestMethod.GET)
	public void downloadInvoice(HttpServletRequest request , HttpServletResponse response) {
		String dataDirectory = request.getServletContext().getRealPath("/WEB-INF/downloads/pdf/");
		String filename = request.getParameter("inv");
		Path file = Paths.get(dataDirectory,filename);
		if (Files.exists(file)) 
        {
            response.setContentType("application/pdf");
            response.addHeader("Content-Disposition", "attachment; filename="+filename);
            try
            {
                Files.copy(file, response.getOutputStream());
                response.getOutputStream().flush();
            } 
            catch (Exception ex) {
                ex.printStackTrace();
            }
        }
//		return "thankyou";
	}
}

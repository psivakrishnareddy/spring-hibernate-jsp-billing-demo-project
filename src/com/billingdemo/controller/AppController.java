package com.billingdemo.controller;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.billingdemo.exception.InvoiceCreationException;
import com.billingdemo.pojo.ActionMsg;
import com.billingdemo.pojo.ActionMsgs;
import com.billingdemo.service.InvoiceService;
import com.billingdemo.service.UserService;
import com.billingdemo.util.constants;

@Controller
@RequestMapping("/")
@ComponentScan("com.billingdemo") 
public class AppController {
	
	@Autowired
	private UserService userService;
	
	
	@Autowired
	private InvoiceService invoiceService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String hello() {
		System.out.println("Welcome to the Service...");
		return "index";
		
	}
	
	@RequestMapping(value="/session-expired",method = RequestMethod.GET)
	public String expiredSession(HttpSession session) {

//		session.invalidate();
		return "sessionexpiry";
		
	}
	
	@RequestMapping(value="/login",method = RequestMethod.GET)
	public String welcome() {
		return "login";
		
	}
	
	@RequestMapping(value="/logout",method = RequestMethod.GET)
	public String logout(HttpSession session) {
		String uname = (String)session.getAttribute("uname");
		userService.updateFlag(uname, 0);
		System.out.println("Loggin Out " + uname);
		session.invalidate();
		return "redirect:/login";
		
	}
	@RequestMapping(value="/register",method = RequestMethod.GET)
	public String registration() {

		return "register";
		
	}
	@RequestMapping(value="/adminregister",method = RequestMethod.GET)
	public String adminRegistration() {
		return "adminreg";
		
	}
	@RequestMapping(value="/register/user",method = RequestMethod.POST)
	public String registerUser(HttpServletRequest request,HttpSession session) {
		String uname=request.getParameter("uname");
		String upass=request.getParameter("upass");
		String ucity = request.getParameter("ucity");
		userService.createCustomer(uname, upass, ucity);
		
		session.setAttribute("uname",uname);
		userService.updateFlag(uname, 1);
		
		return "redirect:/welcome";
	}
	
	@RequestMapping(value="/register/admin",method = RequestMethod.POST)
	public String registerAdmin(HttpServletRequest request,HttpSession session) {
		String uname=request.getParameter("uname");
		String upass=request.getParameter("upass");
		String secret = request.getParameter("secret");
		if(secret.equals("avis")) {
			
			userService.createAdmin(uname, upass);
			session.setAttribute("uname",uname);
			userService.updateFlag(uname, 1);
			return "redirect:/admin";
		}else {
			System.out.println("Permission Denied! Check Your Pass Code");
			return "redirect:/login";
		}
		
		
		
		
	}

	@RequestMapping(value="/admin",method = RequestMethod.GET)
	public String adminWelcome() {

		return "adminpage";
		
	}
	
	@RequestMapping(value="/reports",method = RequestMethod.GET)
	public String adminReports() {

		return "adminreports";
		
	}
	
	@RequestMapping(value="/welcome",method = RequestMethod.GET)
	public String cwel() {

		return "welcome";
		
	}
	@RequestMapping( value = "/checklogin",method = RequestMethod.POST)
	public String userLogin(@RequestParam String uname, @RequestParam String upass, HttpSession session,HttpServletRequest request) {
		System.out.println("Login Controller...........");
	    System.out.println(uname+":"+ upass);
	    constants result = userService.checkUser(uname, upass);
		ActionMsgs errors = new ActionMsgs();
	    if(result.getValue() == 1) {
			session.setAttribute("uname", uname);
			userService.updateFlag(uname, 1);
			return "redirect:/welcome";
		}
		else if(result.getValue() == 0) {
			System.out.println("PLEASE CHECK YOUR PASSWORD");
			ActionMsg error = new ActionMsg("The passworrd is wrong");
			errors.setErrors(error);
			request.setAttribute("errors", errors);
			return "login";
		}
		else if(result.getValue() == 3){
			System.out.println("YOUR ARE ALREADY LOGGED IN");
			session.setAttribute("uname", uname);
			userService.updateFlag(uname, 0);
		
			return "already";
		}
		else if(result.getValue() == 12) {
			
			ActionMsg error = new ActionMsg("Please register first!!");
			errors.setErrors(error);
			request.setAttribute("errors", errors);
			
			return "register";
		}else if(result.getValue() == 11) {
			session.setAttribute("uname", uname);
			userService.updateFlag(uname, 1);
			System.out.println("Admins Login Success!");
			return "redirect:/admin";
		}
		return "register";
		}
	
	@RequestMapping(value = "/admin/reports/dates",method = RequestMethod.POST)
	private String adminReportAll(HttpServletRequest request) {
		
		String from = request.getParameter("fromdate");
		String to = request.getParameter("todate");
	
		Date d1 = Date.valueOf(from);
		Date d2 = Date.valueOf(to);
		try {
			
			invoiceService.getReportsByDate(d1, d2);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
//		e.printStackTrace();
			throw new InvoiceCreationException();
		}
		return "report";
	}
}

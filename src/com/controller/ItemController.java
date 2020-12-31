package com.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.model.ItemDTO;
import com.pojo.ActionMsg;
import com.pojo.ActionMsgs;
import com.service.ItemService;

@Controller
@RequestMapping("/item")
@ComponentScan("com") 
public class ItemController {
	
	@Autowired
	private ItemService itemservice;
	
	
	/*
	 * This methods displays Stock of products in inventory from 3 shops
	 * 
	 */
	@RequestMapping(value="/adminstock",method = RequestMethod.GET)
	public ModelAndView adminStock() {
		
		ModelAndView mnv = new ModelAndView();
		
		List<ItemDTO> items= itemservice.getAll();
		mnv.addObject("itemsObj", items);
		mnv.setViewName("adminstock");
		return mnv;
		
	}
	
	/*
	 * redirects to admin add item page
	 * 
	 */
	@RequestMapping(value="/additem",method = RequestMethod.GET)
	public String adminAddItem() {

		return "adminadditem";
	}
	
	/*
	 * Deletes a item in inventory
	 * 
	 */
	@RequestMapping(value = "/delete-{itemno}" , method = RequestMethod.GET)
	public String deleteItem(@PathVariable int itemno) {
		itemservice.deleteItem(itemno);
		return "redirect:/item/adminstock";
	}
	
	
	/*
	 * Adds the items to Inventory
	 * 
	 */
	@RequestMapping(value = "/add" , method = RequestMethod.POST)
	public String additem(HttpServletRequest request, @RequestParam CommonsMultipartFile fileUpload , ModelMap model,RedirectAttributes redir) {
	
		
//		int itemno = Integer.parseInt(request.getParameter("itemno"));
		String itemname = (String)request.getParameter("itemname");
		String itemprice = (String)request.getParameter("itemprice");
		String itemunit = (String)request.getParameter("itemunit");
		int shopid = Integer.parseInt(request.getParameter("itemshopid"));
		byte[] image = null;
		String base64Encoded =null;
		 if (fileUpload != null ) {
	                image = fileUpload.getBytes();
	                byte[] encodeBase64 = Base64.encodeBase64(image);
	                try {
						base64Encoded = new String(encodeBase64, "UTF-8");
						
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                System.out.println("Saving file: " + fileUpload.getOriginalFilename());
	                              
	            }
	        
		 try {
			 itemservice.addItem(1, itemname, Float.parseFloat(itemprice), itemunit, shopid, image , base64Encoded);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
//		model.addAttribute("message","item added Successfully" );
		
	    redir.addFlashAttribute("message","item added Successfully");
		return "redirect:/item/additem";
	}
	
}

package com.billingdemo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyExceptionHandler {
	
	@ExceptionHandler(value = InvoiceCreationException.class)
	public String invoiceCreationError(InvoiceCreationException exception) {
		
		return "error";
		
	}
	
	@ExceptionHandler(value = ItemAddException.class)
	public String itemAddException(ItemAddException exception) {
		return "error";
	}
	
	@ExceptionHandler(value = ImageUploadException.class)
	public String imageUploadException(ImageUploadException exception) {
		return "error";
	}
	
	@ExceptionHandler(value = InvoiceDownloadException.class)
	public String invoiceDownldExceptio(InvoiceDownloadException exception) {
		return "error";
	}

}

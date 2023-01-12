package com.customexception;

public class ProductNotFoundException extends RuntimeException {
private String message;
	
	

	public ProductNotFoundException(String message) {
	super();
	this.message = message;
}



	@Override
	public String getMessage() {
		return message;
		
	}
}

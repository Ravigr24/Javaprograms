package com.customexception;

public class StudentNotFoundException extends RuntimeException {
	private String message;

	public StudentNotFoundException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
	

}

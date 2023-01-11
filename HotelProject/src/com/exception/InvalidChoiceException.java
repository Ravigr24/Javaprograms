package com.exception;

public class InvalidChoiceException extends RuntimeException {

	private String message;

	public InvalidChoiceException(String message) {
		this.message = message;
	}

	/**
	 * @return the message
	 */
	@Override
	public String getMessage() {
		return message;
	}
	
	
	
	
}

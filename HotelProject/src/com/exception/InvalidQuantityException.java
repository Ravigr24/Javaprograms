package com.exception;

public class InvalidQuantityException extends RuntimeException {

	private String message;

	public InvalidQuantityException(String message) {
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

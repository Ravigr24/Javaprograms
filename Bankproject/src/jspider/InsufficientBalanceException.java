package jspider;

public class InsufficientBalanceException extends RuntimeException {
	private String message;

	InsufficientBalanceException(String message) {

		this.message= message;
	}
	@Override
	public String getMessage() {
		return message;
	}

}

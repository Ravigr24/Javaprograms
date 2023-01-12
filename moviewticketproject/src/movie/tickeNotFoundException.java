package movie;

public class tickeNotFoundException  extends RuntimeException{
	private String message;

	public tickeNotFoundException(String message) {
		super();
		this.message = message;
	}
	@Override
	public String getMessage() {
		return message;
	}
}

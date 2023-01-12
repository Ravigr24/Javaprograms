package movie;

public interface Ticket {
	void bookTicket(int bticket);
	void cancelTicket(int cticket);
	int viewTicket();
	String displayErrorMessage();
}

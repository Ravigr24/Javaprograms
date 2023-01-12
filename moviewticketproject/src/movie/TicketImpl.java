package movie;

public class TicketImpl implements Ticket {
	private int noOfTickets;
	public TicketImpl(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}
	public void bookTicket(int bticket) {
		if(bticket<=noOfTickets) {
		System.out.println("book "+bticket+" tickets");
		noOfTickets=noOfTickets-bticket;
		System.out.println("ticket booked succesfully");
		}
		else {
			try {
			throw new tickeNotFoundException("insufficent tickets");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
				
			}
		}
	}
	int bticket=0;
	public void cancelTicket(int cticket) {
		if(cticket<=bticket) {
		System.out.println("cancel "+cticket+" tickets");
		noOfTickets=noOfTickets+cticket;
		System.out.println("ticket cancelled succesfully");
	}
		else {
			try {
				throw new tickeNotFoundException("insufficent tickets");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
					
				}
		}
	}
	public int viewTicket() {
		return noOfTickets;
	}
	public String displayErrorMessage() {
		return "invalid choice, please enter valid choice"; 
	}
	
}

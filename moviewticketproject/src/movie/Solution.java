package movie;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Ticket t=new TicketImpl(500);
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("1:book\n2:cancel\n3:check available tickets\n4:EXIT");
			System.out.println("Enter choice");
			int choice=scan.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter no of tickets ");
				int bookedTickets=scan.nextInt();
				t.bookTicket(bookedTickets);
				break;

			case 2:
				System.out.println("Enter no of tickets ");
				int cancelTicket=scan.nextInt();
				t.cancelTicket(cancelTicket);
				break;

			case 3:
				System.out.println(t.viewTicket());
				break;
			case 4:
				System.out.println("thank you!!");
				System.exit(0);

			default:
				System.out.println(t.displayErrorMessage());
			}
			System.out.println("------------");
		}
	}
}

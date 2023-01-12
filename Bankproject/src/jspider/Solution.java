package jspider;

import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Bank bank=new BankImpl(5000);
		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("1:Deposit\n2:Withdraw\n3:check balence\n4:EXIT");
			System.out.println("Enter choice");
			int choice=scan.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Amount to be Deposited");
				int amountToDeposited=scan.nextInt();
				bank.deposit(amountToDeposited);//bank.deposit(scan.next());
				break;

			case 2:
				System.out.println("Enter Amount to be Withdraw");
				int amountToWithdraw=scan.nextInt();
				bank.withdraw(amountToWithdraw);//bank.withdraw(scan.next());
				break;

			case 3:
				System.out.println(bank.getBalence());
				break;
			case 4:
				System.out.println("thank you!!");
				System.exit(0);

			default:
				System.out.println(bank.displayErrorMessage());
			}
			System.out.println("------------");
		}
	}

}

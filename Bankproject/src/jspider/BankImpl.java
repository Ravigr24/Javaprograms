package jspider;

public class BankImpl implements Bank{
	private int balance;

	BankImpl(int balance) {
		this.balance = balance;
	}
	@Override
	public void deposit(int amount) {
		System.out.println("Depositing Rs."+amount);
		balance=balance+amount;//balance+=amount;
		System.out.println("Amount Deposited Succesfully");
	}
	@Override
	public void withdraw(int amount) {
		if(amount<=balance) 
		{
			System.out.println("Withdrawing Rs."+amount);
			balance=balance-amount;//balence-=amount;
			System.out.println("Amount Withdrawing  Succesfully");
		}
		else {
			//invoke an exceptionand handle it using try and catch block
			try {
				throw new InsufficientBalanceException("insufficiant balence");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
	@Override
	public int getBalence() {
		return balance;
	}
	@Override
	public String displayErrorMessage() {
		return "invalid Choice, kindly Enter valid Choice";
	}



}

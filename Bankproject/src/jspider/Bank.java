package jspider;

public interface Bank {
	void deposit(int amount);
	void withdraw(int amount);
	int getBalence();
	String displayErrorMessage();

}
//all the methods in interface are automatically public and abstract
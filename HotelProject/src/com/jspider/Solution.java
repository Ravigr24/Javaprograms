package com.jspider;

import java.util.Scanner;

import com.exception.InvalidChoiceException;

public class Solution {

	public static void main(String[] args) {
		
		System.out.println("Welcome to XYZ Hotel");
		System.out.println("----------------");
		
		Scanner scan =new Scanner(System.in);
		HotelManagementSystem hotel =new HotelManagmentSystemimpl();
		
		hotel.addFood();// Adding all food into th DB(MAP)
		
		int input = 1;
		
		while(input == 1) {
		System.out.println("1:Order Food\n2:CheckOut ");
		System.out.println("Enter Choice: ");
		int choice = scan.nextInt();
		
		
			switch(choice) {
			case 1:
				hotel.displayFood();
				hotel.orderFood();
				break;
				
			case 2:
				hotel.checkOut();
				System.out.println("Thank You!!");
				System.exit(0);
				
			default:
				try {
					throw new InvalidChoiceException("Invalid Choice");
				}
				catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				
			}
			
			System.out.println("Enter 1 to continue, Any Other Number to Exit");
			input = scan.nextInt();
			System.out.println("----------");
		}// while end
		System.out.println("Thank You!!");
		
	}
	
}

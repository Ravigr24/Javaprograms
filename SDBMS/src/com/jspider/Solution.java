package com.jspider;

import java.util.Scanner;

import com.customexception.InvalidChoiceException;

public class Solution {
	public static void main(String[] args) {
		//Menu Driven program
		// upcasting
		//System.exit(o);
		//Infinite loop -> while(true){}

		//Acceptinput
		Scanner scan=new Scanner(System.in);

		// achieving upcasting
		StudentManagementSystem sms=new StudentManagementSystemImpl();

		System.out.println("welcome to student database management system");
		System.out.println("----------------------------");
		while(true) {

		System.out.println("1:Add student\n2:Display student");
		System.out.println("3:Display All student\n4:Remove student");
		System.out.println("5:Remove All student\n6:Update student");
		System.out.println("7:Count student\n8:Sort student");
		System.out.println("9:EXIT\nEnter choice");

		int choice=scan.nextInt();

		switch(choice) {
		case 1:
			sms.addStudent();
			break;

		case 2:
			sms.displayStudent();;
			break;

		case 3:
			sms.displayAllStudents();
			break;

		case 4:
			sms.removStudent();;
			break;

		case 5:
			sms.remoAllStudents();;
			break;

		case 6:
			sms.updateStudent();
			break;

		case 7:
			sms.countStudents();
			break;

		case 8:
			sms.sortStudents();
			break;
		case 9:
			System.out.println("Thank you!!");
		    System.exit(0);
		default:
			try {
			throw new InvalidChoiceException("Invalid choice, please enter the correct choice");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		System.out.println("-------------------------------");
		}
	}
}

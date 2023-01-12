package jspider;

import java.util.Scanner;

public class Solution {
	
	static Scanner scan =new Scanner(System.in);
	static int a;
	static int b;
	static void acceptInput() {
		System.out.println("enter the a value ");
		 a =scan.nextInt();
		System.out.println("enter the b value ");
		 b =scan.nextInt();
	}
	
	
	public static void main(String[] args) {
		Calculator calc=new CalculatorImpl();
		Scanner scan=new Scanner(System.in);
		while(true) {
		System.out.println("1:Additon\n2:substraction\n3:multiplication");
		System.out.println("4:division\n5:EXIT");
		System.out.println("enter the choice");
		int choice =scan.nextInt();
		
		if(choice>=1 && choice<=4) {
			acceptInput();
		}
		switch(choice) {
		case 1:
			String add=calc.add(a, b);
			System.out.println(add);
			break;
		case 2:
			System.out.println(calc.sub(a,b));
			break;
		case 3:
			System.out.println(calc.mul(a,b));
			break;
		case 4:
			System.out.println(calc.div(a,b));
			break;
		case 5:
			System.out.println("thank you!");
			System.exit(0);	
		default:
			System.out.println(calc.displayErrorMessage());	
		}
		System.out.println("-------------");
	}
	}

}

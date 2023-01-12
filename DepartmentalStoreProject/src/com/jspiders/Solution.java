package com.jspiders;

import java.util.Scanner;

import com.customexception.InvalidChoiceException;

public class Solution {

	private static void  displayMenu() {
		System.out.println("1:Add Product\n2:Display Product");
		System.out.println("3:Display All Product\n4:Remove Product");
		System.out.println("5:Remove All Product\n6:Update Product");
		System.out.println("7:Count Product\n8:Sort Products");
		System.out.println("9:EXIT\nEnter choice");	
	}

	public static void main(String[] args) {
		Scanner scan=new Scanner(System.in);
		DepartmentalStore store=new DepartmentalStoreImpl();
		
		System.out.println("welcome to Departmental Store system");
		System.out.println("----------------------------");
		while(true) {
		displayMenu();

		int choice=scan.nextInt();
		switch(choice) {
		case 1:
			store.addproduct();
			break;
		case 2:
			store.displayProduct();
			break;
		case 3:
			store.displayAllProduct();;
			break;
		case 4:
			store.removeProduct();;
			break;
		case 5:
			store.removeAllProduct();;
			break;
		case 6:
			store.updateProduct();;
			break;
		case 7:
			store.countProduct();;
			break;
		case 8:
			store.sortProduct();;
			break;
		case 9:
			System.out.println("thank you");
			break;
		default:
		 try {
			throw new InvalidChoiceException(" invalid choice!!,please enter the valid choice");
		 }
		 catch (Exception e) {
			System.out.println(e.getMessage());
		}

		}
		System.out.println("------------------");
		}
	}
}

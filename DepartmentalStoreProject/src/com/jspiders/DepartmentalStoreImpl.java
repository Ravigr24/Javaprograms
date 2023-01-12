package com.jspiders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.customexception.InvalidChoiceException;
import com.customexception.ProductNotFoundException;


import sortinglogic.SortProductById;
import sortinglogic.sortProductByCost;
import sortinglogic.sortProductByName;
import sortinglogic.sortProductByQuantity;



public class DepartmentalStoreImpl implements DepartmentalStore {
	Scanner scan=new Scanner(System.in);
	Map<String, Product> db=new LinkedHashMap<String, Product>();

	@Override
	public void addproduct() {
		System.out.println("enter Name:");
		String name=scan.next();
		System.out.println("enter cost:");
		int cost=scan.nextInt();
		System.out.println("enter quantity:");
		int quantity=scan.nextInt();
		Product p=new Product(name, cost, quantity);
		db.put(p.getId(), p);
		System.out.println("product Inserted Succesfully");
		System.out.println("Your product  id "+p.getId());

	}

	@Override
	public void displayProduct() {
		System.out.println("Enter product id:");
		String id=scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id)) {
			Product p=db.get(id);
			/*System.out.println("Id:"+p.getId());
			System.out.println("Name:"+p.getName());
			System.out.println("Age:"+p.getCost());
			System.out.println("Marks:"+p.getQuantity());*/

			System.out.println(p);//toString() isOverriden ->optional
		}
		else {
			try {
				throw new ProductNotFoundException("Product Not Available to Display");
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}

		}

	}

	@Override
	public void displayAllProduct() {
		Set<String> keys=db.keySet();
		System.out.println("products  list:");
		System.out.println("-----------------");
		if(db.size()!=0) {
			for(String key:keys) {
				System.out.println(db.get(key));// printing reference varivable
			}
		}
		else {
			try {
				throw new ProductNotFoundException("Product Not Available to Display");
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void removeProduct() {
		System.out.println("Enter product Id:");
		String id=scan.next().toUpperCase();
		//id=id.toUpperCase();
		if(db.containsKey(id)) {
			db.remove(id);
			System.out.println("removed succesflly");
		}
		else {
			try {
				throw new ProductNotFoundException("Product Not Available to Display");
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}

	@Override
	public void removeAllProduct() {
		System.out.println("Total product Available:"+db.size());
		db.clear();
		System.out.println("All products removed succesfully ");

	}

	@Override
	public void updateProduct() {
		System.out.println("enter product id:");
		String id=scan.next().toUpperCase();
		if(db.containsKey(id)) {
			Product p=db.get(id);
			System.out.println("1:Update Product Name\n2:Update cost\n3:Update Queantity");
			System.out.println("enter choice:");
			int choice=scan.nextInt();

			switch(choice) {
			case 1:
				System.out.println("Enter Product Name:");
				String name=scan.next();
				p.setName(name);
				System.out.println("product name updatedsuccesfully");
				break;

			case 2:
				System.out.println("Enter cost:");
				p.setCost(scan.nextInt());
				System.out.println("product cost updated succesfully");
				break;

			case 3:
				System.out.println("Enter Quantity:");
				p.setQuantity(scan.nextInt());
				System.out.println("product Quantity updated succesfully");
				break;
			default:
				try {
					throw new InvalidChoiceException("Invalid choice, please enter the correct choice");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
		else {
			try {
				throw new ProductNotFoundException("Product Not Available to Display");
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}

	}

	@Override
	public void countProduct() {
		System.out.println("products Available:"+db.size());

	}

	@Override
	public void sortProduct() {
		Set<String> keys=db.keySet();
		List<Product> list=new ArrayList<Product>();
		for (String key : keys) {
			list.add(db.get(key));
		}
		System.out.println("1:Sort By Id\n2:Sort By Name");
		System.out.println("3:Sort By cost\n4:Sort By Quantity\nEnter Choice");
		int choice=scan.nextInt();
		
		System.out.println("1:Ascending order");
		System.out.println("2:Desending order\nEnter Choice");
		int input=scan.nextInt();
		switch(choice) {
		case 1:
			
			Collections.sort(list, new SortProductById());
			
			if(input==2) {
				Collections.reverse(list);
			}
			display(list);

			break;
		case 2:
			Collections.sort(list, new sortProductByName());
			if(input==2) {
				Collections.reverse(list);
			}
			display(list);

			break;
		case 3:
			Collections.sort(list, new sortProductByCost());
			if(input==2) {
				Collections.reverse(list);
			}
			display(list);

			break;
		case 4:
			Collections.sort(list, new sortProductByQuantity());
			if(input==2) {
				Collections.reverse(list);
			}
			display(list);
			
			break;
		default:
			try {
			throw new InvalidChoiceException("Invalid choice!!, please enter the correct choice");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}
	private static void display(List<Product> list) {
		for(Product s:list) {
			System.out.println(s);
		}
	}

}

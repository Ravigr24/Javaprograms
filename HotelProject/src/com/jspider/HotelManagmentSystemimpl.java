package com.jspider;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.exception.InvalidChoiceException;
import com.exception.InvalidQuantityException;

public class HotelManagmentSystemimpl implements HotelManagementSystem {
	
	Scanner scan = new Scanner(System.in);
	Map<Integer, Food> db = new LinkedHashMap<Integer, Food>();
	double totalCost = 0.00;

	@Override
	public void addFood() {
		// TODO Auto-generated method stub
		db.put(1, new Food(1,"Chicken biryani", 250.00, 5));
		db.put(2, new Food(2,"dum biryani", 350.00, 6));
		db.put(3, new Food(3,"KFC bucket chicken ", 550.50, 10));
		db.put(4, new Food(4,"Burgger  ", 250.00, 15));
		db.put(5, new Food(5,"pizza ", 350.00, 25));
		System.out.println("Food Menu Created");
	}

	@Override
	public void displayFood() {
		// TODO Auto-generated method stub
		Set<Integer> keys = db.keySet();  //1,2,3,4,5
		for(int key : keys) {
			System.out.println("Enter "+key+" -> "+db.get(key));
		}
		
		
	}

	@Override
	public void orderFood() {
		// TODO Auto-generated method stub
		//1. get the food Object based on id/choices -> get()
		System.out.println("Select Food: ");
		int id =scan.nextInt();
	
		if(db.containsKey(id)) {
			Food food = db.get(id);
		System.out.println("Ordering "+food.getName());
		
		//2. accept quantity -> set new Quantity
		System.out.println("Enetr Quantity: ");
		int quantity =scan.nextInt();
		
		if(quantity <= food.getQuantity()) {
			food.setQuantity(food.getQuantity() - quantity);
			Double currentCost = food.getCost()*quantity;
			totalCost = totalCost + currentCost;
			System.out.println("Ordered "+quantity+" "+food.getName()+" at the cost of "+food.getCost());
		}
		else {
			try
			{
				throw new InvalidQuantityException("Invalid Quantity Entered");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		}
		else {
			try{
				throw new InvalidChoiceException("Invalid Choice");
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		}
		
		
		
		// 3. calculate cost 
		// 4. cost -> total Bill
		// 5. InvalidQuantityException
		
	}

	@Override
	public void checkOut() {
		// TODO Auto-generated method stub
		if(totalCost!=0) {
			System.out.println("Total bill in Rs "+totalCost);
		}
		else {
			System.out.println("Please order some food");
		}
		
		
	}
	
			

}

package com.jspider;


import java.util.ArrayList;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.customexception.InvalidChoiceException;
import com.customexception.StudentNotFoundException;
import com.sortinglogic.SortStudentByAge;
import com.sortinglogic.SortStudentById;
import com.sortinglogic.SortStudentByMarks;
import com.sortinglogic.SortStudentByName;

/**
 * 0
 * @author Prashamth Kumar G B
 * @since 2022
 * 
 * we are adding implementation for 8 abstract methods 
 *
 */

public class StudentManagementSystemImpl implements StudentManagementSystem{
	//Collection ->Database  ->Map & LinkedHashMap ->key(String) ->value(Student)
	
	
	Map<String,Student> db=new LinkedHashMap<String,Student>();
	// Scanner
		Scanner scan=new Scanner(System.in);
	@Override
	public void addStudent() {
		//Accept name,age,marks
		//Student objects
		System.out.println("enter Name:");
		String name=scan.next();
		System.out.println("enter Age:");
		int age=scan.nextInt();
		System.out.println("enter Marks:");
		double marks=scan.nextDouble();
		Student s=new Student(age, name, marks);
		db.put(s.getId(), s);
		System.out.println("Student Record Inserted Succesfully");
		System.out.println("Your Student  id "+s.getId());
		
	}

	@Override
	public void displayStudent() {
		System.out.println("Enter Student id:");
		String id=scan.next();
		id=id.toUpperCase();
		if(db.containsKey(id)) {
			Student obj=db.get(id);
			System.out.println("Id:"+obj.getId());
			System.out.println("Name:"+obj.getName());
			System.out.println("Age:"+obj.getAge());
			System.out.println("Marks:"+obj.getMarks());
			//System.out.println(obj);//toString() isOverriden ->optional
		}
		else {
			try {
				throw new StudentNotFoundException("Student Records Not Available to Display");
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
	}

	@Override
	public void displayAllStudents() {
		Set<String> keys=db.keySet();
		System.out.println("Student Records are as Follows:");
		System.out.println("-----------------");
		if(db.size()!=0) {
			for(String key:keys) {
				System.out.println(db.get(key));// printing reference varivable
			}
		}
		else {
			try {
				throw new StudentNotFoundException("Student Records Not Available to Display");
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
	}

	@Override
	public void removStudent() {
		System.out.println("Enter Student Id:");
		String id=scan.next().toUpperCase();
		//id=id.toUpperCase();
		if(db.containsKey(id)) {
			db.remove(id);
			System.out.println("Student Record Deleted Succesfully");
		}
		else {
			try {
				throw new StudentNotFoundException("Student Records Not Found");
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
		
	}

	@Override
	public void remoAllStudents() {
		System.out.println("Total Students Records Available:"+db.size());
		db.clear();
		System.out.println("All students removed succesfully ");
		
	}

	@Override
	public void updateStudent() {
		System.out.println("Enter Student Id:");
		String id=scan.next().toUpperCase();
		if(db.containsKey(id)) {
			Student std=db.get(id);
			System.out.println("1:Update Name\n2:Update Age\n3:Update Marks");
			System.out.println("enter choice:");
			int choice=scan.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Enter Name:");
				String name=scan.next();
				std.setName(name);
				break;
				
			case 2:
				System.out.println("Enter Age:");
				std.setAge(scan.nextInt());
				break;
				
			case 3:
				System.out.println("Enter Marks:");
				std.setMarks(scan.nextDouble());
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
				throw new StudentNotFoundException("Student Records Not Found");
			}
			catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
		}
		
	}

	@Override
	public void countStudents() {
		System.out.println("Total number of student records:" +db.size());
		
	}

	@Override
	public void sortStudents() {
		
		
		/**
		 * Convertig Map into Set
		 * keys are student id and datatype is String
		 */
		Set<String> keys=db.keySet();  //"JSP100","JSP101"
		
		/**
		 * Achieving upcasting between List and ArraList
		 * list can store student objects
		 */
		List<Student> list=new ArrayList<Student>();
		for(String key:keys) {
			list.add(db.get(key));// adiing Student objects from Map to List
		}
		
		System.out.println("1:Sort By Id\n2:Sort By Name");
		System.out.println("3:Sort By Age\n4:Sort By Marks\nEnter Choice");
		int choice=scan.nextInt();
		switch(choice) {
		case 1:
			Collections.sort(list, new SortStudentById());
			display(list);

			break;
		case 2:
			Collections.sort(list, new SortStudentByName());
			display(list);

			break;
		case 3:
			Collections.sort(list, new SortStudentByAge());
			display(list);

			break;
		case 4:
			Collections.sort(list, new SortStudentByMarks());
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
	private static void display(List<Student> list) {
		for(Student s:list) {
			System.out.println(s);
		}
	}
}

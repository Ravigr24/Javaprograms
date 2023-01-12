package jspiders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class MainClass {

	public static void main(String[] args) {
		//creating 3 objects
		Employee e1=new Employee("Jack", 500.00);
		Employee e2=new Employee("John", 700.00);
		Employee e3=new Employee("Alex", 800.00);
		Map<String, Employee> map=new LinkedHashMap<String, Employee>();
		// adding 3 Entries
		map.put(e1.getName(), e1);
		map.put(e2.getName(), e2);
		map.put(e3.getName(), e3);
		// converting map into a set of keys
		Set<String> keys=map.keySet();// "jacj", "john","Alex"

		// created an instance of ArrayList
		List<Employee> list=new ArrayList<Employee>();
		//list.add(map.get("Jack"));//manual

		//Adding values(Employee objects) from Map into ArrayList
		for(String key:keys) {
			list.add(map.get(key));  //Employee obj=map.get(ket);//list.add(obj);
		}
		// traversing Employee objects from ArrayList
		for(Employee emp:list) {
			System.out.println(emp);
		}
		//list.add(map.get("Jack"));
		//list.add(map.get("John"));
		//list.add(map.get("Alex"));

		Scanner scan=new Scanner(System.in);
		while(true) {
			System.out.println("1:Sort by name\n2:sort by salary\n3:Exit");
			System.out.println("enter the choice");
			int choice=scan.nextInt();

			switch(choice) {
			case 1:
				Collections.sort(list,new SortEmployeeByName());
				for(Employee emp:list) {
					System.out.println(emp);
				}
				break;
			case 2:
				Collections.sort(list,new SortEmployeeBySalary());
				for(Employee emp:list) {
					System.out.println(emp);
				}
				break;
			case 3:
				System.out.println("Thank you!!");
				System.exit(0);
			
			default:
				try {
				throw new InvalidChoiceException(" Invalid choice");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}

}

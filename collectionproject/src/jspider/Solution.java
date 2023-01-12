package jspider;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {




		Student s1=new Student(20,"john",46);
		Student s2=new Student(40,"jack",67);
		Student s3=new Student(60,"king",43);
		Student s4=new Student(10,"alex",78);
		Student s5=new Student(30,"smith",84);
		Map<Integer,Student> map=new LinkedHashMap<Integer,Student>();
		map.put(s1.getId(), s1);
		map.put(s2.getId(), s2);
		map.put(s3.getId(), s3);
		map.put(s4.getId(), s4);
		map.put(s5.getId(), s5);

		//convert map into a set of keys

		Set<Integer> keys=map.keySet(); //  20,40,60,10,30
		System.out.println("entries present inside map");
		for(int key:keys) {
			System.out.println(map.get(key));// printing  s1 s2 s3 s4 s5

		}
		System.out.println("-----");
		//add the values from the map into arraylist
		List<Student> l=new ArrayList<Student>();
		for(int key:keys) {
			Student obj=map.get(key);//student obj= new Student(10,"manu",23);
			l.add(obj); //l.add(map.get(key));// getting s1 s2 s3 s4 s5
		}
		System.out.println("objects present in list");
		for(Student s:l) {
			System.out.println(s);
		}
		System.out.println("-------");
		Scanner scan=new Scanner(System.in);
		
		System.out.println("1:sort by id\n2:sort by name\n3:sort by marks\n");
		System.out.println("enter the choice");
		int choice=scan.nextInt();
		switch(choice) {
		case 1:
			Collections.sort(l,new SortStudentById());
			for(Student s:l) {
				System.out.println(s);
			}
			break;
		case 2:
			Collections.sort(l,new SortStudentByName());
			for(Student s:l) {
				System.out.println(s);
			}
			break;
		case 3:
			Collections.sort(l,new SortStudentBymarks());
			for(Student s:l) {
				System.out.println(s);
			}
			break;
		default: System.out.println("enter the valid choice");
		}
	}

}

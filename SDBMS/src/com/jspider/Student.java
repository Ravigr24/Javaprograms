package com.jspider;

public class Student {
	private String id;
	private int age;
	private String name;
	private double marks;
	private static int count=100;
	public Student( int age, String name, double marks) {

		this.id ="JSP"+ count;
		this.age = age;
		this.name = name;
		this.marks = marks;
		count++;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	public static void setCount(int count) {
		Student.count = count;
	}
	public String getId() {
		return id;
	}
	
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
	public double getMarks() {
		return marks;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", age=" + age + ", name=" + name + ", marks=" + marks + "]";
	}
	
	
	

}

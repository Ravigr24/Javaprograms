package jspider;

public class Student {
	private int id;
	private String name;
	private int marks;
	public Student(int id, String name, int marks) {
		this.id = id;
		this.name = name;
		this.marks = marks;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public int getMarks() {
		return marks;
	}
	@Override
	public String toString() {
		return "Id:"+id+" Name:"+name+" Marks:"+marks;
	}
	

}

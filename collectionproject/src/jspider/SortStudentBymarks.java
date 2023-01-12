package jspider;

import java.util.Comparator;

public class SortStudentBymarks implements Comparator<Student> {
	@Override
	public int compare(Student x,Student y ) {
		return x.getMarks()-y.getMarks();
	}
}

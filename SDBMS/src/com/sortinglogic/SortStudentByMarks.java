package com.sortinglogic;

import java.util.Comparator;

import com.jspider.Student;

public class SortStudentByMarks implements Comparator<Student> {
	@Override
	public int compare(Student x,Student y) {
		return (int) (x.getMarks()-y.getMarks()); 
	}
}


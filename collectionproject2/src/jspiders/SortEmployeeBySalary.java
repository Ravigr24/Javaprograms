package jspiders;

import java.util.Comparator;

public class SortEmployeeBySalary implements Comparator<Employee> {

	@Override
	public int compare(Employee x, Employee y) {
		Double i=x.getSalary();
		Double j=y.getSalary();
		return i.compareTo(j);
	}

}
// if return type of getSalary() is  nom primitive Double use
// return x.getSalary().compareTo(y.getSalary());

//x ->object to be inserted & y  -> already existing objects
package jspider;

public class CalculatorImpl implements Calculator{
	@Override
	public String add(int a,int b) {
	
		return "sum of "+a+ " & "+b+ " is "+(a+b);
	}
	@Override
	public String sub(int a,int b) {
		int sub=a-b;
		return "difference of "+a+ " & "+b+ " is "+sub;
	}
	@Override
	public String mul(int a,int b) {
		int mul=a*b;
		return "multitple of "+a+ " & "+b+ " is "+mul;
	}
	@Override
	public String div(int a,int b) {
		if(b!=0) 
			return "division of "+a+ " & "+b+ " is "+(a/b);
		else 
			return "Invalid denominator";
		
	}
	public String displayErrorMessage() {
		return "Invalid choice,please enter valid choice";
	}

}

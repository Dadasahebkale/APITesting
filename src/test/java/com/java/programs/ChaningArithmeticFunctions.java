package com.java.programs;

public class ChaningArithmeticFunctions {

	public static void main(String[] args) {
		ChaningArithmeticFunctions s=new ChaningArithmeticFunctions();
		s.sum().ovi().Div().sub();		

	}
	public ChaningArithmeticFunctions sum() {
		int a=123;
		int b=534;
		int sum=a+b;
		System.out.println("Sum of "+a+" and "+b+" is :"+sum);
		return this;
	}
	public ChaningArithmeticFunctions ovi() {
		int a=156;
		int b=127;
		int c=a*b;
		System.out.println("Multiplication of "+a+" and "+b+" is :"+c);
		return this;
	}
	public ChaningArithmeticFunctions Div() {
		float a=2324;
		float b=1223;
		double c=a/b;
		System.out.println("Division of "+a+" and "+b+" is :"+c);
		return this;
	}
	public ChaningArithmeticFunctions sub() {
		float a=2343145;
		float b=1343243;
		double c=a-b;
		System.out.println("Substraction of "+a+" and "+b+" is :"+c);
		return this;
	}
}

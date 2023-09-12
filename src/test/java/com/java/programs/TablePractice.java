package com.java.programs;

public class TablePractice {

	public static void main(String[] args) {

		int a=2;
		int b=20;
		for(int i=a;i<=b;i++) {
			System.out.println("Multiplication of "+i);
			for(int j=1;j<=10;j++) {
				System.out.println(i+" * "+j+" = "+(i*j));
			}
		}
		
	}

}

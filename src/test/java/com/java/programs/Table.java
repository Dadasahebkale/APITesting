package com.java.programs;

public class Table {
	public static void main(String[] args) {
		int a=2,b=10,c,d;
		
		for(c=a;c<=b;c++) {
			System.out.println("Multiplication of "+c);
			
			for(d=1;d<=10;d++) {
				System.out.println(c+" * "+d+" = "+(c*d));
			}
		}
	}

}

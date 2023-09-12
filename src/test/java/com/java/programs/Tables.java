package com.java.programs;

public class Tables {
	public static void main(String[] args) {
		int a=2,b=30,c,d;
		
		for(c=a;c<=b;c++) {
			System.out.println("Multiplication of table "+c);
			
			for(d=1;d<=10;d++) {
				System.out.println(c+" * "+d+" = "+(c*d));
			}
		}
	}

}

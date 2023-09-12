package com.java.programs;

import java.util.Scanner;

public class TablesActual {
	public static void main(String[] args) {
		int a=2,b=10,c,d;
		
		System.out.println("Enter range of numbers to print their multiplication table");
		//Scanner in = new Scanner(System.in);
		//a = in.nextInt(); b = in.nextInt();
		for (c = a; c <= b; c++)
		{
			System.out.println("Multiplication table of "+c);
		for (d = 1; d <= 10; d++) 
		{ 
			System.out.println(c+"*"+d+" = "+(c*d));
		}
		}
	}

}

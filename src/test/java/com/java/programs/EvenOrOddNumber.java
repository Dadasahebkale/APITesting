package com.java.programs;
import java.util.Scanner;
public class EvenOrOddNumber {

	private static Scanner sc;
	public static void main(String[] args) {
		//EvenOdd();
		//PrintOddnumber();
		SumOfOddnumber();
		ArmStrong();
	}
	public static void EvenOdd() {
		
		int num=0;
		sc = new Scanner(System.in);
		System.out.println("Enter the number for validation :");
		
		num=sc.nextInt();
		if(num%2==0) {
			System.out.println("Even number");
		}else {
			System.out.println("Odd number");
		}
	}
public static void PrintOddnumber() {
	System.out.println("Odd number is ");
	for(int i=0;i<100;i++) {
		if(i%2!=0) {
			System.out.println(i+" ");
		}
	}
}
public static void SumOfOddnumber() {
	int sum=0;
	System.out.print("Sum of numbers is :");
	for(int i=0;i<100;i++) {
		
		if(i%2!=0) {
			sum=sum+i;
		}
		
	}
	System.out.println(sum);
}
public static void ArmStrong() {
	int num,arg,sum=0,rem;
	num=153;
	arg=num;
	for(int i=0;i<num;i++) {
		while(num>0) {
			rem=num%10;
			sum=sum+(rem*rem*rem);
			num=num/10;
		}
	}
	if(arg==sum) {
		System.out.println("Number is armstrong");
	}else {
		System.out.println("Not armstrong");
	}
}
}

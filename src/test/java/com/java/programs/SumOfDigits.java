package com.java.programs;

public class SumOfDigits {

	public static void main(String[] args) {
		
		int num=23455,sum=0,rem=0,temp;
	
		temp=num;
		while(num>0) {
			rem=num%10;
			sum=sum+rem;
			num=num/10;
		}
		System.out.println("Sum of digits of "+temp+" is "+sum);
	}

}

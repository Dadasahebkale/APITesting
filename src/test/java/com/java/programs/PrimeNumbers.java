package com.java.programs;

public class PrimeNumbers {

	public static void main(String[] args) {
		MyPrime();
	}
	public static void MyPrime() {
		int i,j,count;
		System.out.println("1 to 100 prime numbers are :");
		
		for(i=2;i<=100;i++) {
			count=0;
			for(j=2;j<i;j++) {
				if(i%j==0) {
					count++;
					break;
				}
			}
			if(count==0)
				System.out.println(i);
		}
	}
}

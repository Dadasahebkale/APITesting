package com.java.programs;

public class EvenNumber {
	
//	public static void main(String[] args) {
//		
//		sumOfEvenNumber();
//		PrintEvenNumber();
//		TotalSumNumber();
//		
//	}

	public static void sumOfEvenNumber() {
		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				sum = sum + i;
			}
		}
		System.out.println("Sum of even numbers :"+sum);
	}
	public static void PrintEvenNumber() {
		for(int i=1;i<=100;i++) {
			if(i%2==0) {
				System.out.println(i);
			}
		}
	}
	public static void TotalSumNumber() {
		int count=0;
		for(int i=1;i<=100;i++) {
			if(i%2==0) {
				count++;
			}
		}
		System.out.println(count);
	}
}

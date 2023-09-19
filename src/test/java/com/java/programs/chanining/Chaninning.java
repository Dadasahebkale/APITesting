package com.java.programs.chanining;

import java.io.FileOutputStream;

import com.java.programs.OneToHundred;

import groovyjarjarantlr4.v4.parse.GrammarTreeVisitor.channelSpec_return;

public class Chaninning {

	public static void main(String[] args) {
		Chaninning c = new Chaninning();
		c.NPrime().MyPrime().PrimeNumbers().ZeroTohundred().OneToHundred().NormalForLoop().OddNumber().TotalOddNumbers().SumOfOddNumbers().EvenNumber().TotalOfEvenNumbers();
		
		FileOutputStream fio=FileOutputStream("C:\\Users\\Ganesh\\OneDrive\\Desktop\\Output.xlsx");
		
		
		
	}

	private static FileOutputStream FileOutputStream(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public Chaninning OneToHundred() {
		System.out.println("One to Hundered without using any number");
		for (int i = 'a' / 'a'; i <= 'd'; i++) {
			System.out.println(i);

		}
		return this;
	}

	public Chaninning NormalForLoop() {
		System.out.println("One to 100 using string length function");
		int one = 'a' / 'a';
		String s1 = "..........";
		for (int i = one; i <= (s1.length() * s1.length()); i++) {
			System.out.println(i);
		}
		return this;
	}

	public Chaninning ZeroTohundred() {
		String s1 = "programing";
		int zero = s1.length() - s1.length();
		int hundred = s1.length() * s1.length();
		System.out.println("Zero to hundred numbers :");
		for (int i = zero; i <= hundred; i++) {
			System.out.println(i);
		}
		return this;

	}

	public Chaninning OddNumber() {
		System.out.println("The Odd numbers are: ");
		for (int i = 0; i <= 100; i++) {
			if (i % 2 != 0) {
				System.out.println(i + " ");
			}
		}
		return this;
	}

	public Chaninning TotalOddNumbers() {
		int count = 0;
		System.out.println("Total odd number are :");
		for (int i = 0; i <= 'd'; i++) {
			if (i % 2 != 0) {
				count++;
			}

		}
		System.out.println(count);
		return this;
	}

	public Chaninning SumOfOddNumbers() {

		int sum = 0;
		System.out.println("Sum of total odd numbers :");
		for (int i = 0; i <= 'd'; i++) {
			if (i % 2 != 0) {
				sum = sum + i;
			}
		}
		System.out.println(sum);
		return this;
	}

	public Chaninning EvenNumber() {
		System.out.println("Even numbers are :");
		for (int i = 1; i <= 100; i++) {
			if (i % 2 == 0) {
				System.out.println(i);
			}
		}
		return this;
	}

	public Chaninning TotalOfEvenNumbers() {
		int sum = 0;
		System.out.println("Sum of even numbers :");
		for (int i = 'a' / 'a'; i <= 'd'; i++) {
			if (i % 2 == 0) {
				sum = sum + i;
			}
		}
		System.out.println(sum);
		return this;
	}

	public Chaninning PrimeNumbers() {

		System.out.println("Prime numbers are :");
		for (int i = 2; i <= 100; i++) {
			int count = 0;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					count++;
					break;
				}
			}

			if (count == 0) {
				System.out.println(i);
			}
		}
		return this;
	}

	public Chaninning MyPrime() {
		System.out.println("Prime numbers are:");
		int sum = 0;
		for (int i = 2; i <= 100; i++) {
			int count = 0;
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					count++;
					break;
				}

			}

			if (count == 0) {
				sum = sum + i;

				System.out.println(i);

			}

		}
		System.out.println("Total sum of prime number is :" + sum);
		return this;
	}
	public Chaninning NPrime() {
		System.out.println("Prime numbers are :");
		int sum=0;
		for(int i=0;i<=100;i++) {
			int count=0;
			for(int j=i;j>=1;j--) {
				if(i%j==0) {
					count=count+1;
				}
			}
			if(count==2) {
				sum=sum+i;
				System.out.println(i);
			}
		}
		System.out.println("Sum of prime is :"+sum);
		return this;
	}
	
}

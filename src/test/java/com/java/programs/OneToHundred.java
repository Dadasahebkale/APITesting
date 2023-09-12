package com.java.programs;

public class OneToHundred {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		withOutNumber();
		secondApproch();
		AssciValue();
		charValue();
	}
	public static void withOutNumber() {
		int one='A'/'A';
		String s1="..........";
		for(int i=one;i<=(s1.length()*s1.length());i++) {
			System.out.println(i);
		}
	}
	public static void secondApproch() {
		String s="programing";
		int zero=s.length()-s.length();
		int hundered=s.length()*s.length();
		for(int i=zero;i<=hundered;i++) {
			System.out.println(i);
		}
	}
	public static void AssciValue() {
		for(int i='a'/'a';i<='d';i++) {
			System.out.println(i);
		}
	}
	public static void charValue() {
	for (char c = '\n'; c <= 'm'; c++) {
		System.out.println(c - '\t');
	}	
	}
}

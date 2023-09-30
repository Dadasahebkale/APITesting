package com.java.programs;

public class Namaste {

	public static void main(String[] args) {

System.out.println("Namaste all of you !!!");
int a=100;
int sum=0;
int odd=0;
int k=1;
int i=k;
for(i=1;i<=a;i++) {
	if(i%2==0)
	//System.out.println(i);
		sum=sum+i;
	else {
		if(i%2!=0) {
			odd=odd+i;
		}
		//sum=sum+i;
		}
	
	
}
System.out.println("Sum of odd numbers from "+k+" to "+a+" is : " +odd);

System.out.println("Sum of even numbers from "+k+" to "+a+" is : " +sum);

	}

}

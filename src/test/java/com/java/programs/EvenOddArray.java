package com.java.programs;

import java.util.ArrayList;
import java.util.Collections;

public class EvenOddArray {

	public static void main(String[] args) {

		int []MyArray= {1,2,4,6,7,8,9,22,3,77,323,222};
		ArrayList<Integer> evenList=new ArrayList<Integer>();
		ArrayList<Integer> oddList=new ArrayList<Integer>();
		for(int i=0;i<MyArray.length;i++) {
			if(MyArray[i]%2==0) {
				evenList.add(MyArray[i]);
				
			}else {
				oddList.add(MyArray[i]);
				
			}
		}
		Collections.sort(evenList);
		Collections.sort(oddList);
		
		for(int even : evenList)
			System.out.print(even+",");
		System.out.println("\n^^^^^^^^^^^");
		for(int odd : oddList)
			System.out.print(odd+",");
	}

}

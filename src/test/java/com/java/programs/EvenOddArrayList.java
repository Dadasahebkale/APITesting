package com.java.programs;

import java.util.ArrayList;
import java.util.Collections;

public class EvenOddArrayList {

	public static void main(String args[]){

		int myArray[]={1,2,3,4,5,6,8,9,11,23,45,7,12};
		ArrayList<Integer> evenList=new ArrayList<Integer>();
		ArrayList<Integer> oddList=new ArrayList<Integer>();

		for(int i=0; i<myArray.length;i++){

		if(myArray[i]%2==0){
		evenList.add(myArray[i]);
	}
		else{
		oddList.add(myArray[i]);
	}
	}

	Collections.sort(evenList);
	Collections.sort(oddList);

	for(int even :evenList)
	System.out.print(even+",");
	System.out.println("************\n");
	for(int odd :oddList)
	System.out.print(odd+",");

	}

}

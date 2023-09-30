package com.day5;

import com.excelutil.ExcelUtility;

public class Test {
public static String path;
	public static void main(String[] args) {
		path="D:\\CucumberLatest\\RestAssured\\testData\\Userdata.xlsx";
		ExcelUtility eu=new ExcelUtility(path);
		
		System.out.println(eu.getCellCount("sheet1",1));
		System.out.println(eu.getRowCount("sheet1"));
		//for(String e :eu.getCellData("sheet1", 1, 1);
		System.out.println(eu.getCellData("sheet1", 4, 2));
	}
}

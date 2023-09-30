package com.excelutil;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;   
	String path;
	
	public ExcelUtility(String path) {
		this.path=path;
		
		}
	public int getRowCount(String sheetName)
	{
		try {
			fi=new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook=new XSSFWorkbook(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetName);
		int rowcount=sheet.getLastRowNum();
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rowcount;		
	}
	

	public int getCellCount(String sheetName,int rownum)
	{
		try {
			fi=new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook=new XSSFWorkbook(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		int cellcount=row.getLastCellNum();
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cellcount;
	}
	
	
	public String getCellData(String sheetName,int rownum,int colnum)
	{
		try {
			fi=new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook=new XSSFWorkbook(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try{
		data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
		}
		catch(Exception e)
		{
			data="";
		}
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public void setCellData(String sheetName,int rownum,int colnum,String data)
	{
		File xlfile=new File(path);
		if(!xlfile.exists())    // If file not exists then create new file
		{
		workbook=new XSSFWorkbook();
		try {
			fo=new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook.write(fo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
				
		try {
			fi=new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook=new XSSFWorkbook(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		if(workbook.getSheetIndex(sheetName)==-1) // If sheet not exists then create new Sheet
			workbook.createSheet(sheetName);
		sheet=workbook.getSheet(sheetName);
					
		if(sheet.getRow(rownum)==null)   // If row not exists then create new Row
				sheet.createRow(rownum);
		row=sheet.getRow(rownum);
		
		cell=row.createCell(colnum);
		cell.setCellValue(data);
		try {
			fo=new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook.write(fo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void fillGreenColor(String sheetName,int rownum,int colnum)
	{
		try {
			fi=new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook=new XSSFWorkbook(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetName);
		
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND); 
				
		cell.setCellStyle(style);
		try {
			workbook.write(fo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void fillRedColor(String sheetName,int rownum,int colnum)
	{
		try {
			fi=new FileInputStream(path);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook=new XSSFWorkbook(fi);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		style=workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);  
		
		cell.setCellStyle(style);		
		try {
			workbook.write(fo);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fi.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fo.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

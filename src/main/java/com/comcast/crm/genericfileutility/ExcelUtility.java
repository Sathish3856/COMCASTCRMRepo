package com.comcast.crm.genericfileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility 
{
	public String getDataFromExcel(String sheetName,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream("./testdata/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).toString();
		wb.close();
		return data;
		
	}
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException
	{

		FileInputStream fis = new FileInputStream("./testdata/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowNum = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return rowNum;
		
	}
	public void setDataInToExcel(String sheetName,int rowNum,int cellNum,String data) throws EncryptedDocumentException, IOException
	{

		FileInputStream fis = new FileInputStream("./testdata/testscriptdata.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream("./testdata/testscriptdata.xlsx");
		wb.write(fos);
		wb.close();
		
	}

}


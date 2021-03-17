package com.vtigercrm.genericutilies;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtilty {

	public String readDatafromExcel(String sheetname,int rownum,int cellnum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(".\\TestData\\TestData - Copy.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		Row row = sh.getRow(rownum);
		Cell cell = row.getCell(cellnum);
		 return cell.getStringCellValue();
	}
	public String getDataFromExcel(String sheetname,String testcaseID,String columnheader) throws EncryptedDocumentException, IOException
	{
		int expectedrownum=0;
		int expectedcellnum=0;
		FileInputStream fis=new FileInputStream(".\\TestData\\TestData - Copy.xlsx");
		Workbook wb= WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		int lastRowNum = sh.getLastRowNum();
	//	System.out.println(lastRowNum);
		
		//traverse in row
		for(int i=0; i<=lastRowNum; i++)
		{
			String actualID = sh.getRow(i).getCell(0).getStringCellValue();
			if(actualID.equals(testcaseID))
			{
				expectedrownum=i;
				break;
			}
		}
		
			//traverse in column
			int lastCellNum = sh.getRow(expectedrownum).getLastCellNum();
			for(int j=0; j<lastCellNum; j++)
			{
				String actualheader = sh.getRow(expectedrownum-1).getCell(j).getStringCellValue();
				if(actualheader.equals(columnheader))
				{
					expectedcellnum=j;
					break;
				}
			}
			
		//	System.out.println(expectedcellnum);
			return sh.getRow(expectedrownum).getCell(expectedcellnum).getStringCellValue();
		}
	
		public static void main(String[] args) throws EncryptedDocumentException, IOException
		{
			String org=new ExcelUtilty().getDataFromExcel("Sheet", "TC_02","ORGANIZATION NAME");
			String con=new ExcelUtilty().getDataFromExcel("Sheet", "TC_02","CONTACT NAME");
			System.out.println(org);
			System.out.println(con);
		}
}
//String org=new ExcelUtility().readDataFromExcel("Sheet",1,2);
//String con=new ExcelUtility().readDataFromExcel("Sheet",1,3);


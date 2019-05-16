package com.w2a.utilities;

import java.util.Hashtable;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestParameterization {
	
	@Test(dataProvider="getData")
	public void testData(Hashtable<String,String> data){
		System.out.println(data.get("runmode")+"---"+data.get("customer")+"---"+data.get("currency"));
		
	}

	@DataProvider
	public Object[][] getData() {

		ExcelReader excel = new ExcelReader(
				System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\BankManagerSuite.xlsx");
		int rows = excel.getRowCount(Constants.DATA_SHEET);
		System.out.println("Total rows are : " + rows);

		String testName = "OpenAccountTest";

		// Find the testcase start row

		int testCaseStartRowNum = 1;
		for (testCaseStartRowNum = 1; testCaseStartRowNum <= rows; testCaseStartRowNum++) {
			String testCaseName = excel.getCellData(Constants.DATA_SHEET, 0, testCaseStartRowNum);
			if (testCaseName.equals(testName))
				break;

		}

		System.out.println("Test case starts from row num : " + testCaseStartRowNum);

		// Checking total rows in testcase
		int dataStartRowNum = testCaseStartRowNum + 2;
		int testRows = 0;
		while (!excel.getCellData(Constants.DATA_SHEET, 0, dataStartRowNum + testRows).equals("")) {
			testRows++;

		}

		System.out.println("Total rows of data are : " + testRows);

		// Checking total columns in testcase

		int colStartColNum = testCaseStartRowNum + 1;
		int testCols = 0;
		while (!excel.getCellData(Constants.DATA_SHEET, testCols, colStartColNum).equals("")) {
			testCols++;
		}
		System.out.println("Total coloumns are :" + testCols);

		// Printing data
		
		Object[][] data = new Object[testRows][1];
		int i=0;
		for (int rNum = dataStartRowNum; rNum < (dataStartRowNum + testRows); rNum++) {
			Hashtable<String,String> table = new Hashtable<String,String>();
			for (int cNum = 0; cNum < testCols; cNum++) {
				String testData = excel.getCellData(Constants.DATA_SHEET, cNum, rNum);
				String colName = excel.getCellData(Constants.DATA_SHEET, cNum, colStartColNum);
				table.put(colName, testData);
			}
			data[i][0]= table;
			i++;
		}
		
		return data;

	}

}

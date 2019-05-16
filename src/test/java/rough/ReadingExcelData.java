package rough;

import com.w2a.utilities.Constants;
import com.w2a.utilities.ExcelReader;

public class ReadingExcelData {

	public static void main(String[] args) {
		
		
		ExcelReader excel = new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\BankManagerSuite.xlsx");
		int rows = excel.getRowCount(Constants.DATA_SHEET);
		System.out.println("Total rows are : "+rows);
		
		String testName = "AddCustomerTest";
		
		//Find the testcase start row
		
		int testCaseStartRowNum = 1;
		for(testCaseStartRowNum=1;testCaseStartRowNum<=rows;testCaseStartRowNum++){
			String testCaseName = excel.getCellData(Constants.DATA_SHEET, 0, testCaseStartRowNum);
			if(testCaseName.equals(testName))
				break;
			
		}
		
		System.out.println("Test case starts from row num : "+testCaseStartRowNum);
		
		
		//Checking total rows in testcase
		int dataStartRowNum = testCaseStartRowNum+2;
		int testRows = 0;
		while(!excel.getCellData(Constants.DATA_SHEET,0,dataStartRowNum+testRows).equals("")){
			testRows++;
			
		}
		
		System.out.println("Total rows of data are : "+testRows);
		
		
		//Checking total columns in testcase
		
		int colStartColNum = testCaseStartRowNum+1;
		int testCols = 0;
		while(!excel.getCellData(Constants.DATA_SHEET, testCols, colStartColNum).equals("")){
			testCols++;
		}
		System.out.println("Total coloumns are :"+testCols);
		
		//Printing data
		for(int rNum=dataStartRowNum;rNum<(dataStartRowNum+testRows);rNum++){
			for(int cNum=0;cNum<testCols;cNum++){
				System.out.println(excel.getCellData(Constants.DATA_SHEET, cNum, rNum));
			}
		}

	}

}

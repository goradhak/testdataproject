package rough;

import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.DataUtil;

public class CheckingRunmodes {

	public static void main(String[] args) {
		
		String suiteName = "BankManagerSuite";
		boolean suiteRunmode = DataUtil.isSuiteRunnable(suiteName);
		
		System.out.println(suiteRunmode);
		
		String testCaseName = "AddCustomerTest";
		
		boolean testRunmode = DataUtil.isTestRunnable(testCaseName, new ExcelReader(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\BankManagerSuite.xlsx"));
		System.out.println(testRunmode);
	}
	

}

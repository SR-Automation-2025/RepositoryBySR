package AutomationReports;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

	private static ExtentTest test;

	public static void startTest(String testName) {
		test = ExtentManager.getInstance().createTest(testName);
	}

	public static ExtentTest getTest() {
		return test;
	}
}

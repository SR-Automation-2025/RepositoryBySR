package listners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class CustomeModule1Listner implements ITestListener {

	private static final Logger logger = LogManager.getLogger(CustomeModule1Listner.class);

	public void OnFinish(ITestContext context) {
		logger.info("===== Test Suite Execution Finish ====="); // Use ITestListeners
	
		Reporter.log("dfhgchvjbjn"+ 10076879);
	}

	public void OnTestStart(ITestResult result) {
		logger.info("===== Test Suite" + result.getName() + "Started ====="); // Use ITestListeners
	}

	public void OnTestSuccess(ITestResult result) {
		logger.info("===== Test Suite" + result.getName() + "Passed ====="); // Use ITestListeners
	}

	@Override
	public void onStart(ITestContext result) {
		Reporter.log("suite started", true);
		logger.info("===== Test Suite Execution Started ====="); // Use ITestListeners
	}

}

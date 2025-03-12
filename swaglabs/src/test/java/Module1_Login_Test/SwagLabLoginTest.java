package Module1_Login_Test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import AutomationReports.ExtentManager;
import AutomationReports.ExtentTestManager;
import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Module1_Login.SwagLabsHomePage;
import Module1_Login.SwagLabsLoginPage;
import Module1_Login.SwagLabsOpenMenuPage;
import listners.CustomeModule1Listner;

@Listeners(CustomeModule1Listner.class)
public class SwagLabLoginTest extends BaseClass {
	SwagLabsLoginPage login;
	SwagLabsHomePage home;
	SwagLabsOpenMenuPage openMenu;
	private static final Logger logger = LogManager.getLogger(SwagLabLoginTest.class);
	int TCID;

	@BeforeSuite
	public void setup() {
		createLogDirectory();
		// logger.info("===== Test Suite Execution Started ====="); //Use ITestListeners
	}

	@BeforeClass
	public void openBrowser() throws IOException {
		logger.info("------ Initializing Browser ------");
		try {
			initializeBrowser();
			login = new SwagLabsLoginPage(driver);
			home = new SwagLabsHomePage(driver);
			openMenu = new SwagLabsOpenMenuPage(driver);
			login = new SwagLabsLoginPage(driver);

			logger.info("------ POM Objects created ------");
		} catch (Exception e) {
			logger.error("Error during browser initialization: ", e);
			throw e;
		}
	}

	@Test
	public void TestLogin() throws InterruptedException, EncryptedDocumentException, IOException {
		logger.info("===== Starting Test: TestLogin =====");
		ExtentTestManager.startTest("TestLogin");

		try {
			logger.info("result Entering username...");
			login.inpSwagLabsLoginPageUsername(UtilityClass.getPFData("UN"));

			logger.info("Entering password...");
			login.inpSwagLabsLoginPagePaswword(UtilityClass.getPFData("PWD"));
			// login.inpSwagLabsLoginPagePaswword("ssss");

			logger.info("Clicking on the login button...");
			login.clickSwagLabsLoginPageLoginBtn();

			Thread.sleep(2000);

			logger.info("Test Passed: TestLogin");
			ExtentTestManager.getTest().pass("Test Passed Successfully!");

		} catch (Exception e) {
			logger.error("Error during test execution: ", e);
			throw e;
		}

		logger.info("===== Test Completed: TestLogin =====");
	}

//	@Test
//	public void verifyLogoText() throws InterruptedException, EncryptedDocumentException, IOException {
//		TCID = 101;
//		String actLogoText = home.getSwagLabsHomePageLogoText();
//		String expLoloText = UtilityClass.getTD(0, 2);
//
//		Assert.assertEquals(actLogoText, expLoloText, "Failed-both results are diff");
//		Thread.sleep(2000);
//	}

	@AfterMethod
	public void captureResults(ITestResult result) throws IOException {
		if (ExtentManager.getInstance() != null) {
			ExtentManager.getInstance().flush();
			logger.info("Extent Report Generated Successfully!");
		}

		if (result.getStatus() == ITestResult.FAILURE) {
			logger.error("Test Failed: " + result.getName());
			UtilityClass.captureSS(driver, TCID);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.info("Test Passed: " + result.getName());
		} else if (result.getStatus() == ITestResult.SKIP) {
			logger.warn("Test Skipped: " + result.getName());
		}
	}

	@AfterClass
	public void closeBrowser() {
		if (driver != null) {
			logger.info("Closing the browser...");
			try {
				driver.quit();
				logger.info("Browser closed successfully.");
			} catch (Exception e) {
				logger.error("Error while closing the browser: ", e);
			}
		} else {
			logger.warn("Browser was already closed or not initialized.");
		}
	}
}

package Module2;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import LibraryFiles.BaseClass;
import LibraryFiles.UtilityClass;
import Module1_Login.SwagLabsHomePage;
import Module1_Login.SwagLabsLoginPage;
import Module1_Login.SwagLabsOpenMenuPage;

public class SwagLabProductTest extends BaseClass {
	SwagLabsLoginPage login;
	SwagLabsHomePage home;
	SwagLabsOpenMenuPage openMenu;
	int TCID;

	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException {
		initializeBrowser();

		login = new SwagLabsLoginPage(driver);
		home = new SwagLabsHomePage(driver);
		openMenu = new SwagLabsOpenMenuPage(driver);
	}

	@BeforeMethod
	public void loginToApp() throws InterruptedException, EncryptedDocumentException, IOException {
		login.inpSwagLabsLoginPageUsername(UtilityClass.getPFData("UN"));
		login.inpSwagLabsLoginPagePaswword(UtilityClass.getPFData("PWD"));
		login.clickSwagLabsLoginPageLoginBtn();
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void verifyProductName() throws InterruptedException, EncryptedDocumentException, IOException {
		TCID = 102;
		String actProductName = home.getSwagLabsHomePageOneSieProductName();
		String expProductName = UtilityClass.getTD(1, 0);
		Assert.assertEquals(actProductName, expProductName, "Failed-TC2- Act & exp results mismatch  :");
	}

	@Test(priority = 2)
	public void verifyProductPrice() throws InterruptedException, EncryptedDocumentException, IOException {
		TCID = 103;
		double actProductPrice = home.getSwagLabsHomePageOneSieProductPrice();
		double expProductPrice = UtilityClass.getTDInDouble(2, 0);

		Assert.assertEquals(actProductPrice, expProductPrice, "Failed-TC3- Act & exp results mismatch  : ");
	}

	@Test(priority = 3)
	public void verifyProductSize() throws InterruptedException, EncryptedDocumentException, IOException {
		TCID = 104;
		int actProductPrice = home.getSwagLabsHomePageProductSize();
		int expProductPrice = (int) UtilityClass.getTDInDouble(3, 0);

		Assert.assertEquals(actProductPrice, expProductPrice, "Failed-TC4- Act & exp product size mismatch  : ");
	}

	@Test(priority = 4)
	public void verifyProductTotalPrice() throws InterruptedException, EncryptedDocumentException, IOException {
		TCID = 105;
		double actTotalProductPrice = home.getSwagLabsHomePageProductSum();
		double expTotalProductPrice = UtilityClass.getTDInDouble(4, 0);

		Assert.assertEquals(actTotalProductPrice, expTotalProductPrice,
				"Failed-TC5- Act & exp Total product size mismatch  : ");
	}

	@AfterMethod
	public void logoutFromApp(ITestResult s1) throws InterruptedException, IOException {
		if (s1.getStatus() == ITestResult.FAILURE) {
			UtilityClass.captureSS(driver, TCID);
		}

		home.clickSwagLabsHomePageOpenMenuBtn();
		Thread.sleep(2000);
		openMenu.clickSwagLabsOpenMenuPageLogout();
		Thread.sleep(2000);
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}
}
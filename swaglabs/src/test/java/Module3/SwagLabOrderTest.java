package Module3;

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
import Module5_Order.SwagLabCheckoutCompletePage;
import Module5_Order.SwagLabCheckoutInfoPage;
import Module5_Order.SwagLabCheckoutOverviewPage;
import Module5_Order.SwagLabYourCartPage;

public class SwagLabOrderTest extends BaseClass {
	SwagLabsLoginPage login;
	SwagLabsHomePage home;
	SwagLabsOpenMenuPage openMenu;
	SwagLabYourCartPage yourCart;
	SwagLabCheckoutOverviewPage CheckoutOverview;
	SwagLabCheckoutInfoPage checkoutInfo;
	SwagLabCheckoutCompletePage checkoutComplete;

	int TCID;

	@BeforeClass
	public void openBrowser() throws EncryptedDocumentException, IOException {
		initializeBrowser();
		login = new SwagLabsLoginPage(driver);
		home = new SwagLabsHomePage(driver);
		openMenu = new SwagLabsOpenMenuPage(driver);
		yourCart = new SwagLabYourCartPage(driver);
		checkoutInfo = new SwagLabCheckoutInfoPage(driver);
		CheckoutOverview = new SwagLabCheckoutOverviewPage(driver);
		checkoutComplete = new SwagLabCheckoutCompletePage(driver);
	}

	@BeforeMethod
	public void loginToApp() throws InterruptedException, EncryptedDocumentException, IOException {
		login.inpSwagLabsLoginPageUsername(UtilityClass.getPFData("UN"));
		login.inpSwagLabsLoginPagePaswword(UtilityClass.getPFData("PWD"));
		login.clickSwagLabsLoginPageLoginBtn();
		Thread.sleep(2000);
	}

	@Test(priority = 1)
	public void PurchaseAnyProduct() throws InterruptedException, EncryptedDocumentException, IOException {
		home.clickSwagLabHomePageBackPackAddToCart();
		home.clickSwagLabHomePageCartLink();
		Thread.sleep(2000);
		yourCart.clickSwagLabYourCartPageCheckout();
		Thread.sleep(2000);
		checkoutInfo.inpSwagLabCheckoutInfoPageFN(UtilityClass.getTD(5, 0));
		checkoutInfo.inpSwagLabCheckoutInfoPageLN(UtilityClass.getTD(5, 1));
		checkoutInfo.inpSwagLabCheckoutInfoPagePC(UtilityClass.getTD(5, 2));
		checkoutInfo.clickSwagLabCheckoutInfoPageContinueBtn();
		Thread.sleep(2000);
		CheckoutOverview.clickSwagLabCheckoutOverviewPageFinishBtn();
		Thread.sleep(2000);

		String actMsg = checkoutComplete.getSwagLabCheckoutCompletePageOrderDispatchMsg();
		String expMsg = UtilityClass.getTD(5, 3);

		Assert.assertEquals(actMsg, expMsg, "Failed-");
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
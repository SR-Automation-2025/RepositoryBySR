package Module1_Login;

import org.openqa.selenium.WebDriver;
//POM class 3
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsOpenMenuPage {
	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logout;

	public SwagLabsOpenMenuPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void clickSwagLabsOpenMenuPageLogout() {
		logout.click();
	}

}
package Module5_Order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabYourCartPage
{
	@FindBy(xpath = "//button[text()='Checkout']") private WebElement checkout;
	
	
	public SwagLabYourCartPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickSwagLabYourCartPageCheckout() 
	{
		checkout.click();
	}
	

}
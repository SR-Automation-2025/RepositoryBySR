package Module5_Order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabCheckoutInfoPage 
{
	@FindBy(xpath = "//input[@id='first-name']") private WebElement fn;
	@FindBy(xpath = "//input[@id='last-name']") private WebElement ln;
	@FindBy(xpath = "//input[@id='postal-code']") private WebElement postalCode;
	@FindBy(xpath = "//input[@id='continue']") private WebElement continueBtn;
	
	
	public SwagLabCheckoutInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void inpSwagLabCheckoutInfoPageFN(String firstname) 
	{
		fn.sendKeys(firstname);
	}
	
	public void inpSwagLabCheckoutInfoPageLN(String lastname) 
	{
		ln.sendKeys(lastname);
	}
	
	public void inpSwagLabCheckoutInfoPagePC(String PC) 
	{
		postalCode.sendKeys(PC);
	}
	
	public void clickSwagLabCheckoutInfoPageContinueBtn() 
	{
		continueBtn.click();
	}
}
package Module5_Order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabCheckoutCompletePage 
{
	@FindBy(xpath = "//div[@class='complete-text']") private WebElement orderDispatchMsg;
	
	
	public SwagLabCheckoutCompletePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public String getSwagLabCheckoutCompletePageOrderDispatchMsg() 
	{
		return orderDispatchMsg.getText();
	}
}
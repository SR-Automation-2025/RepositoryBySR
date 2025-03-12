package Module5_Order;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabCheckoutOverviewPage 
{
	@FindBy(xpath = "//button[text()='Finish']") private WebElement finish;
	
	
	public SwagLabCheckoutOverviewPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public void clickSwagLabCheckoutOverviewPageFinishBtn() 
	{
		finish.click();
	}
}
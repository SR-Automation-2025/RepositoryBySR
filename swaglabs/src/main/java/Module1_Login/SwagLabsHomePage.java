package Module1_Login;

import java.util.List;

import org.openqa.selenium.WebDriver;
//pom class 2
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwagLabsHomePage {
	@FindBy(xpath = "//div[@class='app_logo']")
	private WebElement logoText;
	@FindBy(xpath = "//button[text()='Open Menu']")
	private WebElement openBtn;
	@FindBy(xpath = "//a[@id='item_2_title_link']")
	private WebElement oneSieProduct;
	@FindBy(xpath = "(//div[@class='inventory_item_price'])[5]")
	private WebElement oneSieProductPrice;
	@FindBy(xpath = "//div[@class='inventory_item_name ']")
	private List<WebElement> allProductsNames;
	@FindBy(xpath = "//div[@class='inventory_item_price']")
	private List<WebElement> allProductsPrice;
	@FindBy(xpath = "(//button[text()='Add to cart'])[1]")
	private WebElement backPackAddToCart;
	@FindBy(xpath = "//a[@class='shopping_cart_link']")
	private WebElement cartLink;

	public SwagLabsHomePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public String getSwagLabsHomePageLogoText() {
		String text = logoText.getText();
		return text;
	}

	public void clickSwagLabsHomePageOpenMenuBtn() {
		openBtn.click();
	}

	public String getSwagLabsHomePageOneSieProductName() {
		String productName = oneSieProduct.getText();
		return productName;
	}

	public double getSwagLabsHomePageOneSieProductPrice() {
		String productPrice = oneSieProductPrice.getText(); // $7.99 -> 7.99
		productPrice = productPrice.substring(1); // 7.99 -> remove 1st char ($)

		double productPriceInDouble = Double.parseDouble(productPrice); // convert String to double

		return productPriceInDouble;
	}

	public int getSwagLabsHomePageProductSize() {
		int ProductSize = allProductsNames.size();
		return ProductSize;
	}

	public double getSwagLabsHomePageProductSum() {
		double totalPrice = 0;

		for (WebElement singleProductPrice : allProductsPrice) {
			String price = singleProductPrice.getText();
			price = price.substring(1);
			double priceInDouble = Double.parseDouble(price);

			totalPrice = totalPrice + priceInDouble;
		}

		return totalPrice;
	}

	public void clickSwagLabHomePageBackPackAddToCart() {
		backPackAddToCart.click();
	}

	public void clickSwagLabHomePageCartLink() {
		cartLink.click();
	}

}

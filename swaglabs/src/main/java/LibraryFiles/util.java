import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WebDriverUtils {

	private WebDriver driver;

	// Constructor to initialize WebDriver
	public WebDriverUtils(WebDriver driver) {
		this.driver = driver;
	}

	// Method to maximize the browser window
	public void maximizeWindow() {
		driver.manage().window().maximize();
	}

	// Method to navigate to a URL
	public void openURL(String url) {
		driver.get(url);
	}

	// Method to refresh the page
	public void refreshPage() {
		driver.navigate().refresh();
	}

	// Method to close the browser
	public void closeBrowser() {
		driver.quit();
	}

}

	2.

	Wait Utilities (Explicit & Implicit Waits)
public class WaitUtils {
    
    private WebDriver driver;
    private WebDriverWait wait;

    public WaitUtils(WebDriver driver, int timeout) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    }

    // Method to wait until element is visible
    public WebElement waitForElementVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Method to wait until element is clickable
    public WebElement waitForElementClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Method to wait for page load completion
    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(
            webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }
}




3. Element Interaction Utilities
public class ElementUtils {
    
    private WebDriver driver;

    public ElementUtils(WebDriver driver) {
        this.driver = driver;
    }

    // Click on an element
    public void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    // Enter text in an input field
    public void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    // Get text from an element
    public String getElementText(By locator) {
        return driver.findElement(locator).getText();
    }

    // Select dropdown by visible text
    public void selectDropdownByText(By locator, String visibleText) {
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(visibleText);
    }
}


4. JavaScript Executor Utilities
public class JavaScriptUtils {
    
    private WebDriver driver;
    private JavascriptExecutor jsExecutor;

    public JavaScriptUtils(WebDriver driver) {
        this.driver = driver;
        this.jsExecutor = (JavascriptExecutor) driver;
    }

    // Click an element using JavaScript
    public void clickElementByJS(WebElement element) {
        jsExecutor.executeScript("arguments[0].click();", element);
    }

    // Scroll to an element
    public void scrollToElement(WebElement element) {
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // Scroll down the page
    public void scrollDown(int pixels) {
        jsExecutor.executeScript("window.scrollBy(0," + pixels + ");");
    }
}

5. Screenshot Utilities
public class ScreenshotUtils {
    
    private WebDriver driver;

    public ScreenshotUtils(WebDriver driver) {
        this.driver = driver;
    }
   
    // Capture a screenshot
    public void captureScreenshot(String filePath) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(srcFile, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

6. File Handling Utilities
public class ExcelUtils {
    
    private static Workbook workbook;
    private static Sheet sheet;

	public static String getTD(int rowIndex, int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\12Oct24.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
		String value = sh.getRow(rowIndex).getCell(colIndex).getStringCellValue();
		return value;
	}

	public static double getTDInDouble(int rowIndex, int colIndex) throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\12Oct24.xlsx");
		Sheet sh = WorkbookFactory.create(file).getSheet("DDF");
		double value = sh.getRow(rowIndex).getCell(colIndex).getNumericCellValue();
		return value;
	}
}

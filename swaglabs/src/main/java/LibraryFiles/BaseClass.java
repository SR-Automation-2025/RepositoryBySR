package LibraryFiles;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {

	public static final Logger logger = LogManager.getLogger(BaseClass.class);
	public WebDriver driver;

	public void initializeBrowser() throws IOException {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		String url = UtilityClass.getPFData("URL");
		
		if (url != null && !url.isEmpty()) {
			logger.info("Navigating to URL: " + url);
			driver.get(url);
		} else {
			logger.error("URL is empty or missing in properties file.");
			throw new IOException("Invalid URL configuration");
		}
	}

	public void createLogDirectory() {
		File logDir = new File("logs");
		if (!logDir.exists()) {
			boolean created = logDir.mkdirs();
			if (created) {
				logger.info("Log directory created: logs/");
			} else {
				logger.error("Failed to create log directory!");
			}
		}
	}
}

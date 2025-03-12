package AutomationReports;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	private static ExtentReports extent;
	private static final String REPORTS_DIRECTORY = "Extents Reports";
	private static final String REPORT_FILE = REPORTS_DIRECTORY + "/extentReport.html";

	public static ExtentReports getInstance() {
		if (extent == null) {
			createReportDirectory();
			ExtentSparkReporter reporter = new ExtentSparkReporter(REPORT_FILE);
			extent = new ExtentReports();
			extent.attachReporter(reporter);
			extent.setSystemInfo("QA", "Syg07");
		}
		return extent;
	}

	private static void createReportDirectory() {
		File reportDir = new File(REPORTS_DIRECTORY);
		if (!reportDir.exists()) {
			boolean created = reportDir.mkdirs();
			if (created) {
				System.out.println("Extent Reports directory created: " + REPORTS_DIRECTORY);
			} else {
				System.out.println("Failed to create Extent Reports directory!");
			}
		}
	}
}

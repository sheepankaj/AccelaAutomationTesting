package com.accelatesting.Utilities;

//Listener class used to generate extent reports
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportingResults extends TestListenerAdapter {

	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extentReports;
	public ExtentTest logger;

	public void onTestStart(ITestContext testContext) {

		String timeStampFormat = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		String reportName = "Test-Report-" + timeStampFormat + ".html";

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/test-output/" + reportName);// specify
																												// location
																												// of
																												// the
																												// report
		htmlReporter.loadXMLConfig(System.getProperty("user.dir") + "/extent-config.xml");

		extentReports = new ExtentReports();

		extentReports.attachReporter(htmlReporter);
		extentReports.setSystemInfo("Host name", "local host");
		extentReports.setSystemInfo("Environment", "QA");
		extentReports.setSystemInfo("user", "mackbookpankaj");

		htmlReporter.config().setDocumentTitle("Accela Automation Testing Project");// Title of the report
		htmlReporter.config().setReportName("Functional testing Automation report");// name of the report
		htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); // location of the chart
		htmlReporter.config().setTheme(Theme.DARK);
	}

	public void onTestSuccess(ITestResult testResult) {
		// System.out.println(testResult.getName());
		logger = extentReports.createTest(testResult.getName()); // create a new entry in the report
		logger.log(Status.PASS, MarkupHelper.createLabel(testResult.getName(), ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult testResult) {
		// System.out.println(testResult.getName());
		logger = extentReports.createTest(testResult.getName()); // create a new entry in the report
		logger.log(Status.FAIL, MarkupHelper.createLabel(testResult.getName(), ExtentColor.RED));

		String screenshotsPath = System.getProperty("user.dir") + "\\Screenshots\\" + testResult.getName() + ".png";

		File file = new File(screenshotsPath);

		if (file.exists()) {
			try {
				logger.fail("Screenshot is below: " + logger.addScreenCaptureFromPath(screenshotsPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void onTestSkipped(ITestResult testResult) {
		logger = extentReports.createTest(testResult.getName()); // create a new entry in the report
		logger.log(Status.SKIP, MarkupHelper.createLabel(testResult.getName(), ExtentColor.YELLOW));
	}

	public void onFinish(ITestResult testResult) {
		extentReports.flush();
	}
}

package com.accelatesting.testCases;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.accelatesting.Utilities.ReadConfig;

public class BaseClass {

	ReadConfig readconfigfile = new ReadConfig();
	// public static Logger logger;
	static Logger logger = LogManager.getLogger(BaseClass.class);
	public String baseUrl = readconfigfile.getApplicationUrl();
	public static WebDriver driver;

	@Parameters("Browsers")
	@BeforeClass
	public void setUp(String browserType) {
		// logger = Logger.getLogger(BaseClass.class);
		// PropertyConfigurator.configure("Log4j.properties");
		if (browserType.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", readconfigfile.getChromeDriverPath());
			driver = new ChromeDriver();
			logger.debug("Chrome Browser selected");
		} else if (browserType.endsWith("firefox")) {
			System.setProperty("webdriver.gecko.driver", readconfigfile.getFireFoxDriverPath());
			driver = new FirefoxDriver();
		} else {
			System.out.println("No browser found");
		}
// System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "/Drivers/chromedriver");
		driver.get(baseUrl);
		driver.manage().window().maximize();
	}

	@AfterClass
	public void closeBrowser() {
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String testcasename) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + testcasename + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
}
